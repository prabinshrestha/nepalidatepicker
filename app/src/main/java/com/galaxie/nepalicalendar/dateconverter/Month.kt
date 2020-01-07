package com.galaxie.nepalicalendar.dateconverter


internal class Month {

    companion object {
        val TOTAL_DAYS_IN_JAN = 31
        val TOTAL_DAYS_IN_FEB = 28
        val TOTAL_DAYS_IN_FEB_LEAP = 29
        val TOTAL_DAYS_IN_MAR = 31
        val TOTAL_DAYS_IN_APR = 30
        val TOTAL_DAYS_IN_MAY = 31
        val TOTAL_DAYS_IN_JUNE = 30
        val TOTAL_DAYS_IN_JULY = 31
        val TOTAL_DAYS_IN_AUG = 31
        val TOTAL_DAYS_IN_SEPT = 30
        val TOTAL_DAYS_IN_OCT = 31
        val TOTAL_DAYS_IN_NOV = 30
        val TOTAL_DAYS_IN_DEC = 31


        val JAN = "JAN"
        val FEB = "FEB"
        val MAR = "MAR"
        val APR = "APR"
        val MAY = "MAY"
        val JUNE = "JUNE"
        val JULY = "JULY"
        val AUG = "AUG"
        val SEPT = "SEPT"
        val OCT = "OCT"
        val NOV = "NOV"
        val DEC = "DEC"


        val BAISHAKH = "BAISHAKH"
        val JESTHA = "JESTHA"
        val ASHADH = "ASHADH"
        val SHRAWAN = "SHRAWAN"
        val BHADRA = "BHADRA"
        val ASHWIN = "ASHWIN"
        val KARTIK = "KARTIK"
        val MANGSIR = "MANGSIR"
        val POUSH = "POUSH"
        val MAGH = "MAGH"
        val FALGUN = "FALGUN"
        val CHAITRA = "CHAITRA"


        fun whichNepaliMonth(nepaliMonth: Int): String {
            var selectedNepaliMonth = BAISHAKH
            when (nepaliMonth) {
                0 -> selectedNepaliMonth = BAISHAKH
                1 -> selectedNepaliMonth = JESTHA
                2 -> selectedNepaliMonth = ASHADH
                3 -> selectedNepaliMonth = SHRAWAN
                4 -> selectedNepaliMonth = BHADRA
                5 -> selectedNepaliMonth = ASHWIN
                6 -> selectedNepaliMonth = KARTIK
                7 -> selectedNepaliMonth = MANGSIR
                8 -> selectedNepaliMonth = POUSH
                9 -> selectedNepaliMonth = MAGH
                10 -> selectedNepaliMonth = FALGUN
                11 -> selectedNepaliMonth = CHAITRA
            }
            return selectedNepaliMonth
        }


        fun whichEnglishMonth(englishMonth: Int): String {
            var selectedEnglishMonth = JAN
            when (englishMonth) {
                0 -> selectedEnglishMonth = JAN
                1 -> selectedEnglishMonth = FEB
                2 -> selectedEnglishMonth = MAR
                3 -> selectedEnglishMonth = APR
                4 -> selectedEnglishMonth = MAY
                5 -> selectedEnglishMonth = JUNE
                6 -> selectedEnglishMonth = JULY
                7 -> selectedEnglishMonth = AUG
                8 -> selectedEnglishMonth = SEPT
                9 -> selectedEnglishMonth = OCT
                10 -> selectedEnglishMonth = NOV
                11 -> selectedEnglishMonth = DEC

            }
            return selectedEnglishMonth
        }


    }


}