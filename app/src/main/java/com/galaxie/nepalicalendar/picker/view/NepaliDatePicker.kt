package com.galaxie.nepalicalendar.picker.view

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.galaxie.nepalicalendar.R
import com.galaxie.nepalicalendar.picker.CalendarMonthRow
import com.galaxie.nepalicalendar.picker.Month
import kotlinx.android.synthetic.main.nepali_date_picker.*
import timber.log.Timber


class NepaliDatePicker : DialogFragment() {

    companion object {
        var KEY_NEPALI_DATE = "KEY_NEPALI_DATE"
        var KEY_DATE_SPLITTER = "KEY_DATE_SPLITTER"
    }

    interface DateListener {
        fun onDateSelected(selectedNepaliDate: String?, selectedEnglishDate: String?)
    }

    private lateinit var rootView: View
    private lateinit var nepaliDatePickerLogic: NepaliDatePickerLogic
    internal lateinit var dateRVAdapter: DateRVAdapter
    var dateListener: DateListener? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(context!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        return dialog
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater!!.inflate(R.layout.nepali_date_picker, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        nepaliDatePickerLogic = NepaliDatePickerLogic(this)
        nepaliDatePickerLogic.onActivityCreated()
    }

    internal fun setNepaliYear(year: String) {
        tvYear.text = "" + year
    }


    internal fun initAdapter() {
        dateRVAdapter = DateRVAdapter(activity!!.applicationContext)
        dateRVAdapter.dateListener = object : DateRVAdapter.DateListener {
            override fun onClickCalendar(month: Int?, day: Int?) {
                if (month != null && day != null) {
                    nepaliDatePickerLogic.onClickCalendar(month, day)
                }
            }

            override fun onMonthSelected(month: Int?) {
                Timber.v("month selected ${Month.whichNepaliMonth(month!!)}")
                rvDateTable.smoothScrollToPosition(month!!)
            }
        }
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvDateTable)
        rvDateTable.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvDateTable.adapter = dateRVAdapter
    }

    internal fun updateDateList(dateList: List<List<CalendarMonthRow>>) {
        Timber.v("size of englishDate" + dateList.size)
        dateRVAdapter.updateDateList(dateList)
    }

    internal fun showToast(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

    internal fun setDate(selectedDate: String) {
        tvNepaliDate.setText(selectedDate)
    }
}