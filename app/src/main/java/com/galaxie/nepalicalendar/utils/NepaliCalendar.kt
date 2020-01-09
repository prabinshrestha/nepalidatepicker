package com.galaxie.nepalicalendar.utils

import com.galaxie.nepalicalendar.picker.CalendarMonthRow
import com.galaxie.nepalicalendar.picker.EnglishDate
import com.galaxie.nepalicalendar.picker.LeapYearUtils
import com.galaxie.nepalicalendar.picker.Week
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

        oneToOneEnglishAndNepaliDateMapping()
    }


    private fun getEnglishDateList(startYear: Int, untillThisYear: Int): List<EnglishDate> {

        var englishDateList = arrayListOf<EnglishDate>()

        for (year in startYear..untillThisYear) {
            var isLeapYear =
                LeapYearUtils.isLeapYear(
                    year
                )
            englishDateList.add(
                EnglishDate(
                    year,
                    isLeapYear
                )
            )
        }

        return englishDateList
    }


    private fun oneToOneEnglishAndNepaliDateMapping() {

        if (englishDateHashMap.size > 0 && nepaliDateHashMap.size > 0) {
            return
        }

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
            var englishMonthInThatYearArray =
                englishDate.month //consist of number of total days in that english year


            //englishMonthIndex = 0 = JAN , daysInEnglishMonth = totalNumberofDaysInThatMonth
            for ((englishMonthIndex, daysInEnglishMonth) in englishMonthInThatYearArray.withIndex()) {


                for (day in 1..daysInEnglishMonth!!) {

                    //we know the JAN(1) 1 2017 is equivalent to nepali 2073 poush(9) 17 consider that month is 0 index later..
                    var nepaliMonthInThatYearArray =
                        nepaliDateSource.get(englishYearMatchWithNepali)

                    var nepaliMonthDaysTotal =
                        nepaliMonthInThatYearArray!!.get(englishMonthMatchWithNepali)

                    // mappingList.add(MappedDate(englishYear, englishMonthIndex, day, englishYearMatchWithNepali, englishMonthMatchWithNepali, englishDayMatchWithNepali, dayInWeek, nepaliMonthDaysTotal))

                    var formattedDateEnglish = "" + englishYear + "_" + String.format(
                        "%02d",
                        englishMonthIndex
                    ) + "_" + String.format("%02d", day)
                    var formattedDateNepali = "" + englishYearMatchWithNepali + "_" + String.format(
                        "%02d",
                        englishMonthMatchWithNepali
                    ) + "_" + String.format("%02d", englishDayMatchWithNepali)
                    englishDateHashMap.put(
                        formattedDateEnglish,
                        MappedDate(
                            englishYear,
                            englishMonthIndex,
                            day,
                            englishYearMatchWithNepali,
                            englishMonthMatchWithNepali,
                            englishDayMatchWithNepali,
                            dayInWeek,
                            nepaliMonthDaysTotal
                        )
                    )
                    nepaliDateHashMap.put(
                        formattedDateNepali,
                        MappedDate(
                            englishYear,
                            englishMonthIndex,
                            day,
                            englishYearMatchWithNepali,
                            englishMonthMatchWithNepali,
                            englishDayMatchWithNepali,
                            dayInWeek,
                            nepaliMonthDaysTotal
                        )
                    )

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
        var dateWithMonthMinusOne = splitDateWithMonthMinusOne(englishDate, formatCharacter)
        var date = dateWithMonthMinusOne.replace(formatCharacter, "_")
        //Timber.v("conversion of this english englishDate $date")
        oneToOneEnglishAndNepaliDateMapping()
        //Timber.v("nep"+GsonUtils.toString(nepaliDateHashMap))
        return englishDateHashMap.get(date)
    }

    fun convertNepaliToEnglish(nepaliDate: String, formatCharacter: String): MappedDate? {
        var dateWithMonthMinusOne = splitDateWithMonthMinusOne(nepaliDate, formatCharacter)
        var date = dateWithMonthMinusOne.replace(formatCharacter, "_")
        // Timber.v("conversion of this nepali englishDate $date")
        oneToOneEnglishAndNepaliDateMapping()
        return nepaliDateHashMap.get(date)
    }


    internal fun splitDateWithMonthMinusOne(
        nepaliOrEnglishDate: String,
        dateSplitter: String
    ): String {
        Timber.v(nepaliOrEnglishDate)
        var date = split(nepaliOrEnglishDate, dateSplitter)
        var year = date[0]
        var month = String.format("%02d", date[1].toInt() - 1)
        var day = String.format("%02d", date[2].toInt())

        var dateWithMonthMinusOne = "$year$dateSplitter$month$dateSplitter$day"

        return dateWithMonthMinusOne
    }


//    internal fun constructNepaliCalendar(mappedDate: MappedDate?): List<List<CalendarMonthRow>> {
//        var dateMapperList = arrayListOf<MappedDate>()
//
//        var yearInNepali = mappedDate?.nepaliYear
//
//        Timber.v("converted ${mappedDate?.englishYear} nepali year $yearInNepali")
//
//        for (month in 0..11) {
//            var newDateMapper = nepaliDateHashMap.get(
//                "$yearInNepali" + "_" + String.format(
//                    "%02d",
//                    month
//                ) + "_" + String.format("%02d", 1)
//            )
//            dateMapperList.add(newDateMapper!!)
//        }
//        return constructCalendar(dateMapperList)
//    }


    internal fun constructNepaliCalendar(
        yearInNepali: Int,
        minNepaliDate: String?,
        maxNepaliDate: String?,
        dateSplitter: String
    ): List<List<CalendarMonthRow>> {
        var dateMapperList = arrayListOf<MappedDate>()
        for (month in 0..11) {
            var newDateMapper = nepaliDateHashMap.get(
                "$yearInNepali" + "_" + String.format(
                    "%02d",
                    month
                ) + "_" + String.format("%02d", 1)
            )
            dateMapperList.add(newDateMapper!!)
        }
        return constructCalendar(dateMapperList, minNepaliDate, maxNepaliDate, dateSplitter)
    }


    private fun constructCalendar(
        mappedDateList: List<MappedDate>?,
        minNepaliDate: String?,
        maxNepaliDate: String?,
        dateSplitter: String
    ): List<List<CalendarMonthRow>> {

        var nepaliTwelveMonthList = arrayListOf<List<CalendarMonthRow>>()

        var calendarMonthRowList: List<CalendarMonthRow>

        for ((index, dateMapper) in mappedDateList!!.withIndex()) {
            //we are going to create 7x7 matrix =49
            calendarMonthRowList = ArrayList<CalendarMonthRow>()
            for (day in 0..6) {
                calendarMonthRowList.add(
                    CalendarMonthRow(
                        false,
                        true, false, false,
                        Week.whichDayInWeek(
                            day
                        ), null, null
                    )
                )
            }

            var totalDayofMonth = dateMapper.totalNepaliDaysInMonth
            var weekdayIndex = dateMapper.dayInWeek

            //calculate pre emty box
            for (i in 0..weekdayIndex - 1) {
                calendarMonthRowList.add(
                    CalendarMonthRow(
                        false,
                        false,
                        true,
                        false,
                        null,
                        0,
                        0
                    )
                )
            }


            //calculate the month
            for (day in 1..totalDayofMonth) {


                var hasMinMaxBoundry = false

                if (maxNepaliDate != null) {

                    var date = split(maxNepaliDate, dateSplitter)

                    var maxYearBoundry = date[0].toInt()
                    var maxMonthBoundry = date[1].toInt() - 1
                    var maxDayBoundry = date[2].toInt()

                    if (dateMapper.nepaliYear > maxYearBoundry) {
                        hasMinMaxBoundry = true
                    }

                    if (dateMapper.nepaliYear == maxYearBoundry && index > maxMonthBoundry) {
                        hasMinMaxBoundry = true
                    }

                    if (dateMapper.nepaliYear == maxYearBoundry && index == maxMonthBoundry && day > maxDayBoundry) {
                        hasMinMaxBoundry = true
                    }

                }

                if (minNepaliDate != null) {

                    var date = split(minNepaliDate, dateSplitter)

                    var minYearBoundry = date[0].toInt()
                    var minMonthBoundry = date[1].toInt() - 1
                    var minDayBoundry = date[2].toInt()

                    if (dateMapper.nepaliYear < minYearBoundry) {
                        hasMinMaxBoundry = true
                    }

                    if (dateMapper.nepaliYear == minYearBoundry && index < minMonthBoundry) {
                        hasMinMaxBoundry = true
                    }

                    if (dateMapper.nepaliYear == minYearBoundry && index == minMonthBoundry && day < minDayBoundry) {
                        hasMinMaxBoundry = true
                    }

                }

                calendarMonthRowList.add(
                    CalendarMonthRow(
                        hasMinMaxBoundry,
                        false,
                        false,
                        true,
                        null,
                        day,
                        0
                    )
                )
            }

            var totalMatrixSize = 49

            //calculate postgap
            var remainingPostGap = 49 - (7 + (weekdayIndex) + totalDayofMonth)

            for (i in 1..remainingPostGap) {
                calendarMonthRowList.add(
                    CalendarMonthRow(
                        false,
                        false,
                        true,
                        false,
                        null,
                        0,
                        0
                    )
                )
            }

            nepaliTwelveMonthList.add(calendarMonthRowList)
        }
        return nepaliTwelveMonthList
    }

    fun split(date: String, dateSplitter: String): List<String> {
        return date.split(dateSplitter)
    }

}