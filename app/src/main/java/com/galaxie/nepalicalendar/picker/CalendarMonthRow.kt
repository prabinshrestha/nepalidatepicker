package com.galaxie.nepalicalendar.picker

internal class CalendarMonthRow {

    var isWeekDay: Boolean
    var isEmptyMatrix: Boolean
    var isRealDate: Boolean
    var weekDayValue: String?
    var gatey: Int?
    var tarik: Int?
    var isClicked: Boolean = false

    constructor(isWeekDay: Boolean, isEmptyMatrix: Boolean, isNepaliDate: Boolean, weekDayValue: String?, gatey: Int?, tarik: Int?) {
        this.isWeekDay = isWeekDay
        this.isEmptyMatrix = isEmptyMatrix
        this.isRealDate = isNepaliDate
        this.weekDayValue = weekDayValue
        this.gatey = gatey
        this.tarik = tarik
    }

}
