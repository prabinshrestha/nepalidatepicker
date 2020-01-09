package com.galaxie.nepalicalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.galaxie.nepalicalendar.utils.NepaliCalendar
import com.galaxie.nepalicalendar.picker.view.NepaliDatePicker
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.*

class MainActivity : AppCompatActivity() {

    private var nepaliCalendar: NepaliCalendar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDate()
    }


    fun initDate() {
        this.nepaliCalendar = NepaliCalendar()
        var mappedDate = nepaliCalendar!!.convertEnglishToNepali("2020-01-01", "-")
        if (mappedDate != null) {
            tvNepaliDate.setText(
                "${mappedDate.displayNepaliDate}"
            )
        }
        //example...
        tvNepaliDate.setOnClickListener(View.OnClickListener {
            var nepaliDatePicker = NepaliDatePicker()
            nepaliDatePicker.dateListener = object : NepaliDatePicker.DateListener {
                override fun onDateSelected(
                    selectedNepaliDate: String?,
                    selectedEnglishDate: String?
                ) {
                    Timber.v("selected nepaliDate $selectedNepaliDate")
                    Timber.v("selected englishDate $selectedEnglishDate")
                    tvNepaliDate.setText(selectedNepaliDate)
                    tvEnglishDate.setText(selectedEnglishDate)
                }
            }
            var bundle = Bundle()
            bundle.putString(NepaliDatePicker.KEY_NEPALI_DATE, tvNepaliDate.text.toString()) //2076-09-16
            // bundle.putString(NepaliDatePicker.KEY_MIN_NEPALI_DATE, "2076-03-03")
            // bundle.putString(NepaliDatePicker.KEY_MAX_NEPALI_DATE, "2077-08-08")
            bundle.putString(NepaliDatePicker.KEY_DATE_SPLITTER, "-")
            nepaliDatePicker.arguments = bundle
            nepaliDatePicker.show(supportFragmentManager, "")
        })

    }


}
