package com.codepen.keepfit.prefs

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class GeneralPrefs {
    companion object{
        fun getTodayDate(): String {
            val date: Date = Calendar.getInstance().time
            val df: DateFormat = SimpleDateFormat("dd MM yyyy")
            return df.format(date)
        }
    }
}