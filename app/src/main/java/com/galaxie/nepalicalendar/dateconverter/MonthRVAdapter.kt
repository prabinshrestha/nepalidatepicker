package com.galaxie.nepalicalendar.dateconverter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.galaxie.nepalicalendar.R

import kotlinx.android.synthetic.main.nepali_date_month_row.view.*
import timber.log.Timber

/**
 * Created by prabin
 * //dont use this for now.....probably will be deleted
 */
class MonthRVAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var dayList: List<String> = arrayListOf()
    private val layoutInflater: LayoutInflater
    private lateinit var layoutView: View
    var monthListener: MonthListener? = null

    var context: Context

    interface MonthListener {
        fun onDaySelected(position: Int, day: String)
    }

    constructor(context: Context) {
        this.context = context
        this.layoutInflater = LayoutInflater.from(context);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nepali_date_month_row, parent, false)
        return PropertyRowViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as PropertyRowViewHolder
        if (dayList.size > 0) {
            viewHolder.tvDay.text = dayList[position]
            viewHolder.tvDay.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    if (monthListener != null) {
                        monthListener?.onDaySelected(position, dayList[position])
                    } else {
                        Timber.v("You have forgot to initiazlie listener!")
                    }
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return dayList.size
    }


    inner class PropertyRowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvDay: AppCompatTextView = itemView.day
    }

    fun updateDayList(dayList: List<String>) {
        this.dayList = dayList
        notifyDataSetChanged()
        Timber.v("count file accountlist : ${this.dayList.size}")
    }


}
