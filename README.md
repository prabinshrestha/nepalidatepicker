# nepalidatepicker
nepali datepicker library for android

    root build.gradle
    allprojects {
        repositories {
            google()
            jcenter()
            maven{url 'https://jitpack.io'}
                    }
                }

    build.gradle
    implementation 'com.github.prabinshrestha:nepalidatepicker:1.0.3' // check the latest release version

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
