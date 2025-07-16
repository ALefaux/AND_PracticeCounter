package fr.alefaux.practicecounter.core.utils.extensions

import java.util.Calendar
import java.util.Date

fun Date.toDateEntity(): String =
    Calendar
        .getInstance()
        .apply {
            time = this@toDateEntity
        }.let { calendar ->
            "${calendar.dayOfMonth()}/${calendar.month()}/${calendar.year()}"
        }
