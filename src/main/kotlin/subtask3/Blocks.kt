package subtask3

import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            Int::class -> {
                var num = 0
                for (i in blockA) {
                    if (i is Int) num += i
                }
                return num

            }
            String::class -> {
                val sb = StringBuilder()
                for (i in blockA) {
                    if (i is CharSequence) sb.append(i)
                }
                return sb.toString()
            }
            else -> {
                val dates = arrayListOf<LocalDate>()
                for (i in blockA) {
                    if (i is LocalDate) dates.add(i)
                }
                val date = dates.max()!!
                val calendar = GregorianCalendar()
                calendar.set(Calendar.YEAR, date.year)
                calendar.set(Calendar.MONTH, date.monthValue - 1)
                calendar.set(Calendar.DAY_OF_MONTH, date.dayOfMonth)
                val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
                return simpleDateFormat.format(calendar.time)
            }
        }
    }
}
