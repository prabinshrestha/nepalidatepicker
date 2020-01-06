package com.galaxie.nepalicalendar.dateconverter


class EnglishDate {

    var year: Int
    var isLeapYear: Boolean
    var month = arrayOfNulls<Int>(12)

    constructor(year: Int, isLeapYear: Boolean) {
        this.year = year
        this.isLeapYear = isLeapYear

        month[0] = Month.TOTAL_DAYS_IN_JAN
        if (this.isLeapYear) {
            month[1] = Month.TOTAL_DAYS_IN_FEB_LEAP
        } else {
            month[1] = Month.TOTAL_DAYS_IN_FEB
        }
        month[2] = Month.TOTAL_DAYS_IN_MAR
        month[3] = Month.TOTAL_DAYS_IN_APR
        month[4] = Month.TOTAL_DAYS_IN_MAY
        month[5] = Month.TOTAL_DAYS_IN_JUNE
        month[6] = Month.TOTAL_DAYS_IN_JULY
        month[7] = Month.TOTAL_DAYS_IN_AUG
        month[8] = Month.TOTAL_DAYS_IN_SEPT
        month[9] = Month.TOTAL_DAYS_IN_OCT
        month[10] = Month.TOTAL_DAYS_IN_NOV
        month[11] = Month.TOTAL_DAYS_IN_DEC
    }


}