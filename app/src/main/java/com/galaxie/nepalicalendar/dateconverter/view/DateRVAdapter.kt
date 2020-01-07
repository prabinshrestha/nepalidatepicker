package com.galaxie.nepalicalendar.dateconverter.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.galaxie.nepalicalendar.R
import com.galaxie.nepalicalendar.dateconverter.CalendarMonthRow
import com.galaxie.nepalicalendar.dateconverter.Month
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
        return PropertyRowViewHolder(layoutView)
    }


    fun setClickColor(clickMonth: Int, clickGateyIndex: Int?) {
        for ((month, calendarMonthRow) in this.calendarMonthw.withIndex()) {
            for ((row, monthRow) in calendarMonthRow.withIndex()) {
                if (clickMonth == month && clickGateyIndex == monthRow.gatey) {
                    monthRow.isClicked = true
                    Timber.v("isclicked set to month $clickMonth gatey $clickGateyIndex")
                } else {
                    monthRow.isClicked = false
                }
            }
        }
        notifyDataSetChanged()
    }


//    fun matchMonthAndDay(clickMonth: Int, day: Int) {
//        for ((month, calendarMonthRow) in this.calendarMonthw.withIndex()) {
//            for ((row, monthRow) in calendarMonthRow.withIndex()) {
//                if (clickMonth == month && day == monthRow.gatey) {
//                    monthRow.isClicked = true
//                    Timber.v("isclicked set to month $clickMonth gatey $day")
//                } else {
//                    monthRow.isClicked = false
//                }
//            }
//        }
//        notifyDataSetChanged()
//    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, month: Int) {
        val viewHolder = holder as PropertyRowViewHolder
        if (calendarMonthw.size > 0) {
            val calendarMonth = calendarMonthw[month]

            //tv0.setText(calendarMonth.get(0).weekDayValue)
            //tv1.setText(calendarMonth.get(1).weekDayValue)

            viewHolder.tvMonthTitle.setText(Month.whichNepaliMonth(month))


            if (calendarMonth.get(7).isRealDate) {
                var calendarMonthRow = calendarMonth.get(7)
                viewHolder.btnGrid7.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid7.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid7.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid7.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid7.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(7).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(7).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid7.setText("")
            }

            if (calendarMonth.get(8).isRealDate) {
                var calendarMonthRow = calendarMonth.get(8)
                viewHolder.btnGrid8.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid8.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid8.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid8.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid8.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(8).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(8).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid8.setText("")
            }

            if (calendarMonth.get(9).isRealDate) {
                var calendarMonthRow = calendarMonth.get(9)

                viewHolder.btnGrid9.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid9.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid9.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid9.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid9.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(9).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(9).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid9.setText("")
            }
            if (calendarMonth.get(10).isRealDate) {
                var calendarMonthRow = calendarMonth.get(10)

                viewHolder.btnGrid10.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid10.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid10.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid10.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid10.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(10).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(10).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid10.setText("")
            }
            if (calendarMonth.get(11).isRealDate) {
                var calendarMonthRow = calendarMonth.get(11)

                viewHolder.btnGrid11.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid11.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid11.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid11.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid11.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(11).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(11).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid11.setText("")
            }
            if (calendarMonth.get(12).isRealDate) {
                var calendarMonthRow = calendarMonth.get(12)
                viewHolder.btnGrid12.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid12.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid12.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid12.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid12.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(12).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(12).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid12.setText("")
            }
            if (calendarMonth.get(13).isRealDate) {
                var calendarMonthRow = calendarMonth.get(13)

                viewHolder.btnGrid13.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid13.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid13.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid13.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid13.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(13).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(13).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid13.setText("")
            }
            if (calendarMonth.get(14).isRealDate) {
                var calendarMonthRow = calendarMonth.get(14)

                viewHolder.btnGrid14.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid14.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid14.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid14.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid14.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(14).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(14).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid14.setText("")
            }
            if (calendarMonth.get(15).isRealDate) {
                var calendarMonthRow = calendarMonth.get(15)

                viewHolder.btnGrid15.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid15.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid15.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid15.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid15.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(15).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(15).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid15.setText("")
            }
            if (calendarMonth.get(16).isRealDate) {
                var calendarMonthRow = calendarMonth.get(16)

                viewHolder.btnGrid16.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid16.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid16.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid16.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid16.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(16).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(16).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid16.setText("")
            }
            if (calendarMonth.get(17).isRealDate) {
                var calendarMonthRow = calendarMonth.get(17)

                viewHolder.btnGrid17.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid17.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid17.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid17.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid17.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(17).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(17).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid17.setText("")
            }
            if (calendarMonth.get(18).isRealDate) {
                var calendarMonthRow = calendarMonth.get(18)

                viewHolder.btnGrid18.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid18.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid18.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid18.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid18.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(18).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(18).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid18.setText("")
            }
            if (calendarMonth.get(19).isRealDate) {
                var calendarMonthRow = calendarMonth.get(19)

                viewHolder.btnGrid19.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid19.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid19.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid19.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid19.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(19).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(19).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid19.setText("")
            }
            if (calendarMonth.get(20).isRealDate) {
                var calendarMonthRow = calendarMonth.get(20)

                viewHolder.btnGrid20.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid20.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid20.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid20.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid20.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(20).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(20).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid20.setText("")
            }
            if (calendarMonth.get(21).isRealDate) {
                var calendarMonthRow = calendarMonth.get(21)

                viewHolder.btnGrid21.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid21.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid21.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid21.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid21.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(21).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(21).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid21.setText("")
            }
            if (calendarMonth.get(22).isRealDate) {
                var calendarMonthRow = calendarMonth.get(22)

                viewHolder.btnGrid22.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid22.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid22.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid22.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid22.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(22).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(22).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid22.setText("")
            }
            if (calendarMonth.get(23).isRealDate) {
                var calendarMonthRow = calendarMonth.get(23)

                viewHolder.btnGrid23.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid23.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid23.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid23.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid23.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(23).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(23).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid23.setText("")
            }
            if (calendarMonth.get(24).isRealDate) {
                var calendarMonthRow = calendarMonth.get(24)

                viewHolder.btnGrid24.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid24.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid24.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid24.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid24.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(24).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(24).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid24.setText("")
            }
            if (calendarMonth.get(25).isRealDate) {
                var calendarMonthRow = calendarMonth.get(25)

                viewHolder.btnGrid25.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid25.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid25.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid25.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid25.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(25).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(25).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid25.setText("")
            }
            if (calendarMonth.get(26).isRealDate) {
                var calendarMonthRow = calendarMonth.get(26)

                viewHolder.btnGrid26.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid26.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid26.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid26.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid26.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(26).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(26).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid26.setText("")
            }
            if (calendarMonth.get(27).isRealDate) {
                var calendarMonthRow = calendarMonth.get(27)

                viewHolder.btnGrid27.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid27.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid27.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid27.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid27.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(27).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(27).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid27.setText("")
            }
            if (calendarMonth.get(28).isRealDate) {
                var calendarMonthRow = calendarMonth.get(28)

                viewHolder.btnGrid28.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid28.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid28.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid28.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid28.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(28).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(28).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid28.setText("")
            }
            if (calendarMonth.get(29).isRealDate) {
                var calendarMonthRow = calendarMonth.get(29)

                viewHolder.btnGrid29.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid29.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid29.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid29.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid29.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(29).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(29).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid29.setText("")
            }
            if (calendarMonth.get(30).isRealDate) {
                var calendarMonthRow = calendarMonth.get(30)

                viewHolder.btnGrid30.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid30.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid30.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid30.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid30.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(30).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(30).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid30.setText("")
            }
            if (calendarMonth.get(31).isRealDate) {
                var calendarMonthRow = calendarMonth.get(31)

                viewHolder.btnGrid31.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid31.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid31.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid31.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid31.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(31).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(31).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid31.setText("")
            }
            if (calendarMonth.get(32).isRealDate) {
                var calendarMonthRow = calendarMonth.get(32)

                viewHolder.btnGrid32.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid32.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid32.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid32.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid32.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(32).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(32).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid32.setText("")
            }
            if (calendarMonth.get(33).isRealDate) {
                var calendarMonthRow = calendarMonth.get(33)

                viewHolder.btnGrid33.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid33.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid33.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid33.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid33.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(33).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(33).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid33.setText("")
            }
            if (calendarMonth.get(34).isRealDate) {
                var calendarMonthRow = calendarMonth.get(34)

                viewHolder.btnGrid34.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid34.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid34.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid34.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid34.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(34).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(34).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid34.setText("")
            }
            if (calendarMonth.get(35).isRealDate) {
                var calendarMonthRow = calendarMonth.get(35)

                viewHolder.btnGrid35.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid35.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid35.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid35.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid35.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(35).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(35).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid35.setText("")
            }
            if (calendarMonth.get(36).isRealDate) {
                var calendarMonthRow = calendarMonth.get(36)

                viewHolder.btnGrid36.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid36.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid36.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid36.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid36.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(36).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(36).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid36.setText("")
            }
            if (calendarMonth.get(37).isRealDate) {
                var calendarMonthRow = calendarMonth.get(37)

                viewHolder.btnGrid37.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid37.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid37.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid37.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid37.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(37).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(37).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid37.setText("")
            }
            if (calendarMonth.get(38).isRealDate) {
                var calendarMonthRow = calendarMonth.get(38)

                viewHolder.btnGrid38.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid38.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid38.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid38.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid38.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(38).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(38).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid38.setText("")
            }
            if (calendarMonth.get(39).isRealDate) {
                var calendarMonthRow = calendarMonth.get(39)

                viewHolder.btnGrid39.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid39.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid39.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid39.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid39.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(39).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(39).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid39.setText("")
            }
            if (calendarMonth.get(40).isRealDate) {
                var calendarMonthRow = calendarMonth.get(40)

                viewHolder.btnGrid40.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid40.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid40.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid40.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid40.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(40).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(40).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid40.setText("")
            }
            if (calendarMonth.get(41).isRealDate) {
                var calendarMonthRow = calendarMonth.get(41)

                viewHolder.btnGrid41.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid41.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid41.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid41.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid41.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(41).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(41).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid41.setText("")
            }
            if (calendarMonth.get(42).isRealDate) {
                var calendarMonthRow = calendarMonth.get(42)

                viewHolder.btnGrid42.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid42.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid42.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid42.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid42.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(42).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(42).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid42.setText("")
            }
            if (calendarMonth.get(43).isRealDate) {
                var calendarMonthRow = calendarMonth.get(43)

                viewHolder.btnGrid43.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid43.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid43.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid43.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid43.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(43).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(43).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid43.setText("")
            }
            if (calendarMonth.get(44).isRealDate) {
                var calendarMonthRow = calendarMonth.get(44)

                viewHolder.btnGrid44.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid44.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid44.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid44.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid44.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(44).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(44).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid44.setText("")
            }
            if (calendarMonth.get(45).isRealDate) {
                var calendarMonthRow = calendarMonth.get(45)

                viewHolder.btnGrid45.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid45.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid45.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid45.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid45.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(45).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(45).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid45.setText("")
            }
            if (calendarMonth.get(46).isRealDate) {
                var calendarMonthRow = calendarMonth.get(46)

                viewHolder.btnGrid46.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid46.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid46.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid46.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid46.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(46).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(46).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid46.setText("")
            }
            if (calendarMonth.get(47).isRealDate) {
                var calendarMonthRow = calendarMonth.get(47)

                viewHolder.btnGrid47.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid47.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid47.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid47.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid47.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(47).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(47).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid47.setText("")
            }
            if (calendarMonth.get(48).isRealDate) {
                var calendarMonthRow = calendarMonth.get(48)

                viewHolder.btnGrid48.setText("" + calendarMonthRow.gatey)
                if (calendarMonthRow.isClicked) {
                    viewHolder.btnGrid48.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.gray_light
                        )
                    )
                } else {
                    viewHolder.btnGrid48.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.calendar_false
                        )
                    )
                    viewHolder.btnGrid48.setBackgroundResource(R.drawable.cell_border)
                }
                viewHolder.btnGrid48.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (dateListener != null) {
                            setClickColor(month, calendarMonth.get(48).gatey)
                            dateListener!!.onClickCalendar(month, calendarMonth.get(48).gatey)
                        } else {
                            Timber.v("You have forgot to initiazlie listener!")
                        }
                    }
                })
            } else {
                viewHolder.btnGrid48.setText("")
            }


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

        }
    }

    override fun getItemCount(): Int {
        return calendarMonthw?.size ?: 0
    }


    inner class PropertyRowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvMonthTitle: AppCompatTextView = itemView.tvMonthTitle
        var ivPrevMonth: AppCompatImageView = itemView.ivPrevMonth
        var ivNextMonth: AppCompatImageView = itemView.ivNextMonth
        var btnGrid7: AppCompatTextView = itemView.btnGrid7
        var btnGrid8: AppCompatTextView = itemView.btnGrid8
        var btnGrid9: AppCompatTextView = itemView.btnGrid9
        var btnGrid10: AppCompatTextView = itemView.btnGrid10
        var btnGrid11: AppCompatTextView = itemView.btnGrid11
        var btnGrid12: AppCompatTextView = itemView.btnGrid12
        var btnGrid13: AppCompatTextView = itemView.btnGrid13
        var btnGrid14: AppCompatTextView = itemView.btnGrid14
        var btnGrid15: AppCompatTextView = itemView.btnGrid15
        var btnGrid16: AppCompatTextView = itemView.btnGrid16
        var btnGrid17: AppCompatTextView = itemView.btnGrid17
        var btnGrid18: AppCompatTextView = itemView.btnGrid18
        var btnGrid19: AppCompatTextView = itemView.btnGrid19
        var btnGrid20: AppCompatTextView = itemView.btnGrid20
        var btnGrid21: AppCompatTextView = itemView.btnGrid21
        var btnGrid22: AppCompatTextView = itemView.btnGrid22
        var btnGrid23: AppCompatTextView = itemView.btnGrid23
        var btnGrid24: AppCompatTextView = itemView.btnGrid24
        var btnGrid25: AppCompatTextView = itemView.btnGrid25
        var btnGrid26: AppCompatTextView = itemView.btnGrid26
        var btnGrid27: AppCompatTextView = itemView.btnGrid27
        var btnGrid28: AppCompatTextView = itemView.btnGrid28
        var btnGrid29: AppCompatTextView = itemView.btnGrid29
        var btnGrid30: AppCompatTextView = itemView.btnGrid30
        var btnGrid31: AppCompatTextView = itemView.btnGrid31
        var btnGrid32: AppCompatTextView = itemView.btnGrid32
        var btnGrid33: AppCompatTextView = itemView.btnGrid33
        var btnGrid34: AppCompatTextView = itemView.btnGrid34
        var btnGrid35: AppCompatTextView = itemView.btnGrid35
        var btnGrid36: AppCompatTextView = itemView.btnGrid36
        var btnGrid37: AppCompatTextView = itemView.btnGrid37
        var btnGrid38: AppCompatTextView = itemView.btnGrid38
        var btnGrid39: AppCompatTextView = itemView.btnGrid39
        var btnGrid40: AppCompatTextView = itemView.btnGrid40
        var btnGrid41: AppCompatTextView = itemView.btnGrid41
        var btnGrid42: AppCompatTextView = itemView.btnGrid42
        var btnGrid43: AppCompatTextView = itemView.btnGrid43
        var btnGrid44: AppCompatTextView = itemView.btnGrid44
        var btnGrid45: AppCompatTextView = itemView.btnGrid45
        var btnGrid46: AppCompatTextView = itemView.btnGrid46
        var btnGrid47: AppCompatTextView = itemView.btnGrid47
        var btnGrid48: AppCompatTextView = itemView.btnGrid48


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
