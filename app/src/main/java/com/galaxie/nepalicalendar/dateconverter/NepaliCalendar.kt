package com.galaxie.nepalicalendar.dateconverter

import timber.log.Timber


class NepaliCalendar {

    private var nepaliDateSource = HashMap<Int, Array<Int>>()
    private var englishDateHashMap = HashMap<String, MappedDate>()
    private var nepaliDateHashMap = HashMap<String, MappedDate>()

    constructor() {
        nepaliDateSource.put(2073, arrayOf(31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31))
        nepaliDateSource.put(2074, arrayOf(31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30))
        nepaliDateSource.put(2075, arrayOf(31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30))
        nepaliDateSource.put(2076, arrayOf(31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30))
        nepaliDateSource.put(2077, arrayOf(31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31))
        nepaliDateSource.put(2078, arrayOf(31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30))
        nepaliDateSource.put(2079, arrayOf(31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30))
        nepaliDateSource.put(2080, arrayOf(31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30))
        nepaliDateSource.put(2081, arrayOf(31, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30))
        nepaliDateSource.put(2082, arrayOf(30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30))
        nepaliDateSource.put(2083, arrayOf(31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30))
        nepaliDateSource.put(2084, arrayOf(31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30))
        nepaliDateSource.put(2085, arrayOf(31, 32, 31, 32, 30, 31, 30, 30, 29, 30, 30, 30))
        nepaliDateSource.put(2086, arrayOf(30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30))
        nepaliDateSource.put(2087, arrayOf(31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30))
        nepaliDateSource.put(2088, arrayOf(30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30))
        nepaliDateSource.put(2089, arrayOf(30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30))
    }


    private fun getEnglishDateList(startYear: Int, untillThisYear: Int): List<EnglishDate> {

        var englishDateList = arrayListOf<EnglishDate>()

        for (year in startYear..untillThisYear) {
            var isLeapYear = LeapYearUtils.isLeapYear(year)
            englishDateList.add(EnglishDate(year, isLeapYear))
        }

        return englishDateList
    }


    private fun oneToOneEnglishAndNepaliDateMapping() {
        //clear the previous hashmap
        englishDateHashMap.clear()
        nepaliDateHashMap.clear()

        var englishDateList = getEnglishDateList(2017, 2032)

        // var mappingList = arrayListOf<MappedDate>()

        var englishYearMatchWithNepali = 2073
        var englishMonthMatchWithNepali = 9 - 1; //cauze year is 0 index
        var englishDayMatchWithNepali = 17
        var dayInWeek = 1 - 1 // cauze its a zero index

        for (englishDate in englishDateList) { // gives the englishDate list starting from 2017 JAN

            var englishYear = englishDate.year
            var englishMonthInThatYearArray = englishDate.month //consist of number of total days in that english year

            for ((englishMonthIndex, daysInEnglishMonth) in englishMonthInThatYearArray.withIndex()) {


                for (day in 1..daysInEnglishMonth!!) {

                    //we know the JAN(1) 1 2017 is equivalent to nepali 2073 poush(9) 17 consider that month is 0 index later..
                    var nepaliMonthInThatYearArray = nepaliDateSource.get(englishYearMatchWithNepali)

                    var nepaliMonthDaysTotal = nepaliMonthInThatYearArray!!.get(englishMonthMatchWithNepali)

                    // mappingList.add(MappedDate(englishYear, englishMonthIndex, day, englishYearMatchWithNepali, englishMonthMatchWithNepali, englishDayMatchWithNepali, dayInWeek, nepaliMonthDaysTotal))

                    var formattedDateEnglish = "" + englishYear + "_" + String.format("%02d", englishMonthIndex) + "_" + String.format("%02d", day)
                    var formattedDateNepali = "" + englishYearMatchWithNepali + "_" + String.format("%02d", englishMonthMatchWithNepali) + "_" + String.format("%02d", englishDayMatchWithNepali)
                    englishDateHashMap.put(formattedDateEnglish, MappedDate(englishYear, englishMonthIndex, day, englishYearMatchWithNepali, englishMonthMatchWithNepali, englishDayMatchWithNepali, dayInWeek, nepaliMonthDaysTotal))
                    nepaliDateHashMap.put(formattedDateNepali, MappedDate(englishYear, englishMonthIndex, day, englishYearMatchWithNepali, englishMonthMatchWithNepali, englishDayMatchWithNepali, dayInWeek, nepaliMonthDaysTotal))

                   // Timber.v("formatdatenepali"+formattedDateNepali +","+formattedDateEnglish)
                   // Timber.v("formatdateenglish"+formattedDateEnglish+","+formattedDateNepali)

                    englishDayMatchWithNepali = englishDayMatchWithNepali + 1
                    dayInWeek = dayInWeek + 1

                    if (dayInWeek > 6) {
                        dayInWeek = 0
                    }

                    if (englishDayMatchWithNepali > nepaliMonthDaysTotal) {
                        englishDayMatchWithNepali = 1
                        englishMonthMatchWithNepali = englishMonthMatchWithNepali + 1

                        if (englishMonthMatchWithNepali > 11) {
                            englishYearMatchWithNepali = englishYearMatchWithNepali + 1
                            englishMonthMatchWithNepali = 0
                        }
                    }

                }

            }


        }
    }

    fun convertEnglishToNepali(englishDate: String, formatCharacter: String): MappedDate? {
        var date = englishDate.replace(formatCharacter, "_")
        Timber.v("conversion of this english englishDate $date")
        oneToOneEnglishAndNepaliDateMapping()
        //Timber.v("nep"+GsonUtils.toString(nepaliDateHashMap))
        return englishDateHashMap.get(date)
    }

    fun map(nepaliDate: String, formatCharacter: String): MappedDate? {
        var date = nepaliDate.replace(formatCharacter, "_")
        Timber.v("conversion of this nepali englishDate $date")
        oneToOneEnglishAndNepaliDateMapping()
       // printEnglishHashMap()
       // printNepaliHashMap()
      //  Timber.v("nep"+GsonUtils.toString(nepaliDateHashMap))
       // Timber.v("eng"+GsonUtils.toString(englishDateHashMap))
        return nepaliDateHashMap.get(date)
    }

    internal fun constructNepaliCalendar(mappedDate: MappedDate?): List<List<CalendarMonthRow>> {
        var dateMapperList = arrayListOf<MappedDate>()

        var yearInNepali = mappedDate?.nepaliYear

        Timber.v("converted ${mappedDate?.englishYear} nepali year $yearInNepali")

        for (month in 0..11) {
            var newDateMapper = nepaliDateHashMap.get("$yearInNepali" + "_" + String.format("%02d", month) + "_" + String.format("%02d", 1))
            dateMapperList.add(newDateMapper!!)
        }
        return constructCalendar(dateMapperList)
    }


    private fun constructCalendar(mappedDateList: List<MappedDate>?): List<List<CalendarMonthRow>> {

        var nepaliTwelveMonthList = arrayListOf<List<CalendarMonthRow>>()

        var calendarMonthRowList: List<CalendarMonthRow>

        for (dateMapper in mappedDateList!!) {
            //we are going to create 7x7 matrix =49
            calendarMonthRowList = ArrayList<CalendarMonthRow>()
            for (day in 0..6) {
                calendarMonthRowList.add(CalendarMonthRow(true, false, false,
                    Week.whichDayInWeek(day), null, null))
            }

            var totalDayofMonth = dateMapper!!.totalNepaliDaysInMonth
            var weekdayIndex = dateMapper.dayInWeek

            //calculate pre emty box
            for (i in 0..weekdayIndex - 1) {
                calendarMonthRowList.add(CalendarMonthRow(false, true, false, null, 0, 0))
            }


            //calculate the real englishDate
            for (day in 1..totalDayofMonth) {
                calendarMonthRowList.add(CalendarMonthRow(false, false, true, null, day, 0))
            }

            var totalMatrixSize = 49

            //calculate postgap
            var remainingPostGap = 49 - (7 + (weekdayIndex) + totalDayofMonth)

            for (i in 1..remainingPostGap) {
                calendarMonthRowList.add(CalendarMonthRow(false, true, false, null, 0, 0))
            }

            nepaliTwelveMonthList.add(calendarMonthRowList)
        }
        return nepaliTwelveMonthList
    }

    private fun printNepaliHashMap(){
        for(data in nepaliDateHashMap){
            Timber.v("nep"+data.key)
        }
    }

    private fun printEnglishHashMap(){
        for(data in englishDateHashMap){
            Timber.v("eng"+data.key)
        }
    }


}