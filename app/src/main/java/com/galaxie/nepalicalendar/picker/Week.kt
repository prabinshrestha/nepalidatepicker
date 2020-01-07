package com.galaxie.nepalicalendar.picker


internal class Week {
    companion object {
        val SUN = "SUN"
        val MON = "MON"
        val TUE = "TUE"
        val WED = "WED"
        val THU = "THU"
        val FRI = "FRI"
        val SAT = "SAT"


        fun whichDayInWeek(dayInWeek: Int): String {
            var selectedDayInWeek = SUN
            when (dayInWeek) {
                0 -> selectedDayInWeek = SUN
                1 -> selectedDayInWeek = MON
                2 -> selectedDayInWeek = TUE
                3 -> selectedDayInWeek = WED
                4 -> selectedDayInWeek = THU
                5 -> selectedDayInWeek = FRI
                6 -> selectedDayInWeek = SAT
            }
            return selectedDayInWeek
        }


    }


}