package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val calendar = GregorianCalendar()
        calendar.set(Calendar.DAY_OF_MONTH, day.toInt())
        calendar.set(Calendar.MONTH, month.toInt() - 1)
        calendar.set(Calendar.YEAR,year.toInt())
        val dateFormat = SimpleDateFormat("d MMMM, EEEE")
        if (day.toInt() !in 1..31 || month.toInt() !in 1..12) return "Такого дня не существует"
        if (day.toInt() == 29 && month.toInt() == 2) {
            return if (calendar.isLeapYear(year.toInt())) dateFormat.format(calendar.time)
            else "Такого дня не существует"
        }
        return dateFormat.format(calendar.time)
    }
}
