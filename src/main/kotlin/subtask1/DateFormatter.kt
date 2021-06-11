package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val calendar = GregorianCalendar()
        calendar.set(Calendar.DAY_OF_MONTH, day.toInt())
        calendar.set(Calendar.MONTH, month.toInt() - 1)
        calendar.set(Calendar.YEAR,year.toInt())
        val locale = Locale("ru")
        val dateFormat = SimpleDateFormat("d MMMM, EEEE",locale)
        calendar.isLenient = false
        return try {
            dateFormat.format(calendar.time)
        } catch (e: Exception) {
            "Такого дня не существует"
        }
    }
}
