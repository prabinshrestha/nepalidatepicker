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
    var dateMapper: MappedDate? = null;
    var year: Int = 0
    var month: Int = 0
    var day: Int = 0

    var selectedDate: String = ""
    var dateSplitter = "-"

    constructor(fragment: NepaliDatePicker) {
        this.fragment = fragment
    }

    fun onActivityCreated() {


        var bundle = fragment.arguments

        if (bundle != null) {
            var nepaliDate = bundle.get(NepaliDatePicker.KEY_NEPALI_DATE) as String
            dateSplitter = bundle.get(NepaliDatePicker.KEY_DATE_SPLITTER) as String


            if (dateSplitter == null) {
                Timber.v("Please provide the splitter for englishDate eg - or / for a englishDate 2075-1-1 or 2075/1/1")
                return
            }

            Timber.v("nepali englishDate passed for picker $nepaliDate")


            year = (nepaliDate.split(dateSplitter).get(0)).toInt()
            month = (nepaliDate.split(dateSplitter).get(1)).toInt() - 1
            day = (nepaliDate.split(dateSplitter).get(2)).toInt()

            //represent the upper most header year, name of month day
            //since month is 0 index we have to adjust month by subtract 1 since (month+1) must come in  month = (nepaliDate.split(dateSplitter).get(1)).toInt()
            fragment.setDate("$year,${Month.whichNepaliMonth(month)} ${String.format("%02d", day)}")
            fragment.setNepaliYear("" + year) // represent < year > in picker


            var adjustedDate =
                "" + year + "-" + (String.format("%02d", month)) + "-" + (String.format(
                    "%02d",
                    day
                ))


            //represent the row of month
            dateMapper = nepaliCalendar.map(adjustedDate, dateSplitter)
            fragment.initAdapter()
            generateCalendar(dateMapper)
            //set the default click month in the box of picker
            fragment.dateRVAdapter.setDefaultClickMonthRow(month, day)
            fragment.rvDateTable.scrollToPosition(month)

            fragment.btnCancel.setOnClickListener(View.OnClickListener {
                fragment.dismiss()
            })

            fragment.btnOk.setOnClickListener(View.OnClickListener {
                if (fragment.dateListener != null) {
                    //since month is 0 index so to adjust we have to add 1
                    selectedDate =
                        "$year$dateSplitter${String.format(
                            "%02d",
                            month
                        )}$dateSplitter${String.format("%02d", day)}"
                    var mappedDate: MappedDate = nepaliCalendar.map(selectedDate, "-")!!

                    var displayEnglishText = "${mappedDate.englishYear}$dateSplitter${String.format(
                        "%02d",
                        mappedDate.englishMonth + 1
                    )}$dateSplitter${String.format("%02d", mappedDate.englishDay)}"
                    var displayNepaliText = "$year$dateSplitter${String.format(
                        "%02d",
                        month + 1
                    )}$dateSplitter${String.format("%02d", day)}"
                    fragment.dateListener!!.onDateSelected(
                        displayNepaliText,
                        displayEnglishText
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


    fun generateCalendar(dateMapper: MappedDate?) {
        fragment.updateDateList(nepaliCalendar.constructNepaliCalendar(dateMapper))
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

        var updatedYear = year + 1

        if (validateDate(updatedYear)) {
            year = updatedYear

            Timber.v("next year is clicked " + year)
            dateMapper = nepaliCalendar.map(
                year.toString() + "-${String.format(
                    "%02d",
                    1
                )}-${String.format("%02d", 1)}", "-"
            )
            generateCalendar(dateMapper)
            fragment.setNepaliYear("" + year)
        }
    }

    fun previousYear() {
        var updatedYear = year - 1
        if (validateDate(updatedYear)) {
            year = updatedYear

            Timber.v("previous year is clicked " + year)
            dateMapper = nepaliCalendar.map(
                year.toString() + "-${String.format(
                    "%02d",
                    1
                )}-${String.format("%02d", 1)}", "-"
            )
            generateCalendar(dateMapper)
            fragment.setNepaliYear("" + year)
        }
    }

    fun onClickCalendar(month: Int, day: Int) {
        Timber.v("on englishDate selection $year$dateSplitter$month$dateSplitter$day")
        this.month = month
        this.day = day
        fragment.setDate("$year,${Month.whichNepaliMonth(month)} ${String.format("%02d", day)}")
    }
}