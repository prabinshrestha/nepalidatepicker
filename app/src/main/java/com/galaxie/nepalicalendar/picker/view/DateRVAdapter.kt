package com.galaxie.nepalicalendar.picker.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.galaxie.nepalicalendar.R
import com.galaxie.nepalicalendar.picker.CalendarMonthRow
import com.galaxie.nepalicalendar.picker.Month
import kotlinx.android.synthetic.main.nepali_date_picker_row.view.*
import timber.log.Timber


internal class DateRVAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var calendarMonthw: List<List<CalendarMonthRow>> = arrayListOf()
    private val layoutInflater: LayoutInflater
    private lateinit var layoutView: View
    var dateListener: DateListener? = null

    var context: Context

    interface DateListener {
        fun onClickCalendar(month: Int?, day: Int?)
        fun onMonthSelected(month: Int?)
    }

    constructor(context: Context) {
        this.context = context
        this.layoutInflater = LayoutInflater.from(context);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.nepali_date_picker_row, parent, false)
        return DateRowViewHolder(layoutView)
    }


    fun setClickColor(clickMonth: Int, clickGateyIndex: Int?) {
        for ((month, calendarMonthRow) in this.calendarMonthw.withIndex()) {
            for ((row, monthRow) in calendarMonthRow.withIndex()) {
                if (clickMonth == month && clickGateyIndex == monthRow.gatey) {
                    monthRow.isClicked = true
                    // Timber.v("isclicked set to month $clickMonth gatey $clickGateyIndex")
                } else {
                    monthRow.isClicked = false
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, month: Int) {
        val viewHolder = holder as DateRowViewHolder
        if (calendarMonthw.size > 0) {
            var calendarMonth = calendarMonthw[month]

            viewHolder.tvMonthTitle.setText(Month.whichNepaliMonth(month))

            viewHolder.ivPrevMonth.setOnClickListener {
                if (dateListener != null) {
                    var updatedMonth = month - 1
                    if (updatedMonth >= 0) {
                        dateListener!!.onMonthSelected(updatedMonth)
                    }
                }
            }

            viewHolder.ivNextMonth.setOnClickListener {
                if (dateListener != null) {
                    var updatedMonth = month + 1
                    if (updatedMonth <= 11) {
                        dateListener!!.onMonthSelected(updatedMonth)
                    }
                }
            }


            val tableRowCount = viewHolder.tlCalendar.childCount

            var boxIndex = -1

            for (tableRowIndex in 0 until tableRowCount) {
                val tableRow = viewHolder.tlCalendar.getChildAt(tableRowIndex) as TableRow
                val tableRowColumnCount = tableRow.childCount

                for (tableRowChildIndex in 0 until tableRowColumnCount) {

                    boxIndex += 1

                    if (boxIndex >= 7) {
                        val tvGatey = tableRow.getChildAt(tableRowChildIndex) as AppCompatTextView
                        //Timber.v("$tableRowChildIndex" + calendarMonth.get(boxIndex).isRealDate)
                        val calendarMonthRow = calendarMonth.get(boxIndex)

                        if (calendarMonthRow.isRealDate) {
                            tvGatey.setText("" + calendarMonthRow.gatey)

                            if (calendarMonthRow.hasMinMaxDateBoundry) {
                                tvGatey.setOnClickListener(null)
                                tvGatey.setBackgroundResource(R.drawable.minmaxboundry)
                            } else {
                                if (calendarMonthRow.isClicked) {
                                    tvGatey.setBackgroundColor(
                                        ContextCompat.getColor(
                                            context,
                                            R.color.gray_light
                                        )
                                    )
                                } else {
                                    tvGatey.setBackgroundColor(
                                        ContextCompat.getColor(
                                            context,
                                            R.color.calendar_false
                                        )
                                    )
                                    tvGatey.setBackgroundResource(R.drawable.cell_border)
                                }
                                tvGatey.setOnClickListener {
                                    if (dateListener != null) {
                                        setClickColor(
                                            month,
                                            calendarMonthRow.gatey
                                        )
                                        //since month is 0 index just add 1
                                        dateListener!!.onClickCalendar(
                                            month+1,
                                            calendarMonthRow.gatey
                                        )
                                    } else {
                                        Timber.v("You have forgot to initiazlie listener!")
                                    }
                                }
                            }
                        } else {
                            tvGatey.setText("")
                            tvGatey.setOnClickListener(null)
                            tvGatey.setBackgroundColor(
                                ContextCompat.getColor(
                                    context,
                                    R.color.calendar_false
                                )
                            )
                            tvGatey.setBackgroundResource(R.drawable.cell_border)
                        }
                    }

                }
            }


        }

    }


    override fun getItemCount(): Int {
        return calendarMonthw?.size ?: 0
    }


    inner class DateRowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tlCalendar: TableLayout = itemView.tlCalendar
        var tvMonthTitle: AppCompatTextView = itemView.tvMonthTitle
        var ivPrevMonth: AppCompatImageView = itemView.ivPrevMonth
        var ivNextMonth: AppCompatImageView = itemView.ivNextMonth
    }

    fun updateDateList(dateList: List<List<CalendarMonthRow>>) {
        this.calendarMonthw = dateList
        notifyDataSetChanged()
    }

    //always call after fun updateDateList(dateList: List<List<CalendarMonthRow>>)
    fun setDefaultClickMonthRow(month: Int, gatey: Int) {
        setClickColor(month, gatey)
    }


}
