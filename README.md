# nepalicalendar
nepali calendar library for android


    fun initDate() {

        this.nepaliCalendar = NepaliCalendar()

        var calendar = Calendar.getInstance()
        var englishDate = "" + calendar.get(Calendar.YEAR) + "-" + String.format(
            "%02d",
            calendar.get(Calendar.MONTH)
        ) + "-" + String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)) // 2019-01-01
        var mappedDate = nepaliCalendar!!.convertEnglishToNepali(englishDate, "-")
        if (mappedDate != null) {
            //since month is 0 index we have to adjust by adding 1 to it
            tvNepaliDate.setText(
                "${mappedDate.nepaliYear}-${String.format(
                    "%02d",
                    (mappedDate.nepaliMonth + 1)
                )}-${String.format("%02d", mappedDate.nepaliDay)}" // 2076-09-16
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
            bundle.putString(NepaliDatePicker.KEY_NEPALI_DATE, tvNepaliDate.text.toString())  // 2076-09-16
            bundle.putString(NepaliDatePicker.KEY_DATE_SPLITTER, "-")
            nepaliDatePicker.arguments = bundle
            nepaliDatePicker.show(supportFragmentManager, "")
        })
    }
