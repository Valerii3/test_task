fun compress(input: String): String {
    val compressed = StringBuilder()
    var countConsecutive = 0
    for (i in 0 until input.length) {
        countConsecutive++
        if (i + 1 >= input.length || input[i] != input[i + 1]) {
            val char = input[i]
            compressed.append("$char±$countConsecutive")
            countConsecutive = 0
        }
    }
    return if (compressed.length < input.length) compressed.toString() else input
}

fun decompress(compressed: String): String {
    val chars = compressed.split("±")
    val decompressed = StringBuilder()
    for (i in 0 until chars.size - 1) {
        val char = chars[i].last()
        val countPart = chars[i + 1]
        val count = if (i + 1 == chars.size - 1) {
            countPart.toInt()
        } else {
            countPart.substring(0, countPart.length - 1).toInt()
        }
        for (j in 0 until count) {
            decompressed.append(char)
        }
    }
    return decompressed.toString()
}

fun main(args: Array<String>) {
    println(compress("AAAAABBB#####"))
    println(decompress("A±5B±3#±5"))
}