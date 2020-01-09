package com.galaxie.nepalicalendar.picker.view

import android.view.View
import com.galaxie.nepalicalendar.utils.MappedDate
import com.galaxie.nepalicalendar.picker.Month
import com.galaxie.nepalicalendar.utils.NepaliCalendar
import kotlinx.android.synthetic.main.nepali_date_picker.*
import timber.log.Timber


internal class NepaliDatePickerLogic {

    var fragment: NepaliDatePicker
    var nepaliCalendar = NepaliCalendar()
    var yearInNepali: Int = 0
    var monthInNepali: Int = 0
    var dayInNepali: Int = 0

    var selectedNepaliDate: String = ""
    var dateSplitter: String? = "-"
    var minNepaliDate: String? = null
    var maxNepaliDate: String? = null
    var nepaliDate: String? = null

    constructor(fragment: NepaliDatePicker) {
        this.fragment = fragment
    }


    fun onActivityCreated() {


        var bundle = fragment.arguments

        if (bundle != null) {
            nepaliDate = bundle.getString(NepaliDatePicker.KEY_NEPALI_DATE)
            dateSplitter = bundle.getString(NepaliDatePicker.KEY_DATE_SPLITTER)
            minNepaliDate = bundle.getString(NepaliDatePicker.KEY_MIN_NEPALI_DATE)
            maxNepaliDate = bundle.getString(NepaliDatePicker.KEY_MAX_NEPALI_DATE)

            if (nepaliDate == null) {
                Timber.v("Please provide date on bundle key ${NepaliDatePicker.KEY_NEPALI_DATE} - or / for a nepalidate 2075-1-1 or 2075/1/1")
                return
            }

            if (dateSplitter == null) {
                Timber.v("Please provide date splitter on bundle key ${NepaliDatePicker.KEY_DATE_SPLITTER} eg - or / for a nepalidate 2075-1-1 or 2075/1/1")
                return
            }

            Timber.v("nepali date passed for picker $nepaliDate")

            yearInNepali = (nepaliDate!!.split(dateSplitter!!).get(0)).toInt()
            monthInNepali = (nepaliDate!!.split(dateSplitter!!).get(1)).toInt()
            dayInNepali = (nepaliDate!!.split(dateSplitter!!).get(2)).toInt()

            //represent the upper most header year, name of month day
            //since month is 0 index we have to adjust month by subtract 1 since (month+1) must come in  month = (nepaliDate.split(dateSplitter).get(1)).toInt()
            fragment.setNepaliDate(
                "$yearInNepali,${Month.whichNepaliMonth(monthInNepali - 1)} ${String.format(
                    "%02d",
                    dayInNepali
                )}"
            )
            fragment.setNepaliYear("" + yearInNepali) // represent < year > in picker
            fragment.setEnglishDate(
                nepaliCalendar.convertNepaliToEnglish(
                    nepaliDate!!,
                    dateSplitter!!
                )!!.displayEnglishDate!!
            )


            fragment.initAdapter()
            generateCalendar()
            //set the default click month in the box of picker
            fragment.dateRVAdapter.setDefaultClickMonthRow(monthInNepali - 1, dayInNepali)
            fragment.rvDateTable.scrollToPosition(monthInNepali - 1)

            fragment.btnCancel.setOnClickListener(View.OnClickListener {
                fragment.dismiss()
            })

            fragment.btnSet.setOnClickListener(View.OnClickListener {
                if (fragment.dateListener != null) {
                    //since month is 0 index so to adjust we have to add 1


                    selectedNepaliDate =
                        "$yearInNepali$dateSplitter$monthInNepali$dateSplitter$dayInNepali"

                    var mappedDate: MappedDate =
                        nepaliCalendar.convertNepaliToEnglish(selectedNepaliDate, "-")!!

                    fragment.dateListener!!.onDateSelected(
                        mappedDate.displayNepaliDate,
                        mappedDate.displayEnglishDate
                    )
                    fragment.dismiss()
                } else {
                    Timber.v("You forgot to initialize englishDate listener!")
                }
            })

            fragment.ivPrevYear.setOnClickListener(View.OnClickListener {
                previousYear()
            })

            fragment.ivNextYear.setOnClickListener(View.OnClickListener {
                nextYear()
            })
        }

    }


    fun generateCalendar() {
        fragment.updateDateList(
            nepaliCalendar.constructNepaliCalendar(
                yearInNepali,
                minNepaliDate,
                maxNepaliDate,
                dateSplitter!!
            )
        )
    }

    fun validateDate(updatedYear: Int): Boolean {
        Timber.v("updated year $updatedYear")
        if (updatedYear == 2073) {
            //Timber.v("nepalli year shouldn't be less than 2074 : no data found for previous year!")
            fragment.showToast("Data not found for year 2073")
            return false
        } else if (updatedYear == 2089) {
            // Timber.v("nepalli year should be less than 2077 : no data found for 2077!")
            fragment.showToast("Data not found for year 2089")
            return false
        }
        return true
    }


    fun nextYear() {
        var nextYear = yearInNepali + 1

        if (validateDate(nextYear)) {
            yearInNepali = nextYear
            Timber.v("next year is clicked " + yearInNepali)
            generateCalendar()
            fragment.setNepaliYear("" + yearInNepali)
        }
    }

    fun previousYear() {
        var prevYear = yearInNepali - 1
        if (validateDate(prevYear)) {
            yearInNepali = prevYear
            Timber.v("previous year is clicked " + yearInNepali)
            generateCalendar()
            fragment.setNepaliYear("" + yearInNepali)
        }
    }


    fun onClickCalendar(month: Int, day: Int) {
        // Timber.v("on englishDate selection $year$dateSplitter$month$dateSplitter$day")
        this.monthInNepali = month
        this.dayInNepali = day
        fragment.setNepaliDate(
            "$yearInNepali,${Month.whichNepaliMonth(month-1)} ${String.format(
                "%02d",
                day
            )}"
        )
        var mappedDate = nepaliCalendar.convertNepaliToEnglish(
            "$yearInNepali-${String.format(
                "%02d",
                month
            )}-${String.format("%02d", day)}", "-"
        )
        fragment.setEnglishDate(mappedDate!!.displayEnglishDate!!)

    }
}