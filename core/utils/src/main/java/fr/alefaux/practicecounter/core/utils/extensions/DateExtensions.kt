package fr.alefaux.practicecounter.core.utils.extensions

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun Date.format(): String =
    Calendar
        .getInstance()
        .apply {
            time = this@format
        }.let { calendar ->
            "${calendar.dayOfMonth()}/${calendar.month()}/${calendar.year()}"
        }

fun Date.isToday(): Boolean =
    format() == Date().format()

fun Date.formatForDisplay(): String =
    SimpleDateFormat.getDateInstance().format(this)
