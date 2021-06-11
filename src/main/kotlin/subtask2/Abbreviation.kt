package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val capitalize = ('A'..'Z')
        var copyA = a
        var sb = StringBuilder()
        for (i in b) {
            while (copyA.isNotEmpty()) {
                if (i == copyA[0] || i == copyA[0].toUpperCase()) {
                    sb.append(copyA[0].toUpperCase())
                    copyA = copyA.drop(1)
                    break
                }
                if (copyA[0] in capitalize) return "NO"
                copyA = copyA.drop(1)
            }
        }
        if (b != sb.toString()) return "NO"
        return "YES"
    }
}
