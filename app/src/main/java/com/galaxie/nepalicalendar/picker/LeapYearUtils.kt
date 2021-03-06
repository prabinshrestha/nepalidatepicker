package com.galaxie.nepalicalendar.picker

/**
 *
 * https://www.wikihow.com/Calculate-Leap-Years
 * https://www.timeanddate.com/calendar/months/
 */
internal class LeapYearUtils {

    companion object {

        fun isLeapYear(year: Int): Boolean {

            if (year % 4 != 0) {
                return false
            } else {
                if (year % 100 != 0) {
                    return true
                } else {
                    if (year % 400 == 0) {
                        return true
                    }
                }
            }
            return false
        }

    }
}