package Day01

import println
import readInput

fun main() {
    val map = mutableMapOf<String, Int>(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    fun getFirst(input: String): Int? {
        var i = 0
        while (i < input.length) {
            if (input[i].isDigit()) return input[i].digitToInt()
            map.keys.firstOrNull { input.substring(i).startsWith(it) }?.let { return map[it] }
            i++
        }

        return null
    }

    fun getLast(input: String): Int? {
        var i = input.length-1
        while (i >= 0) {
            if (input[i].isDigit()) return input[i].digitToInt()
            map.keys.firstOrNull { input.substring(0, i+1).endsWith(it) }?.let { return map[it] }
            i--
        }

        return null
    }

    fun main(input: List<String>): Int {
        var sum = 0

        for (line in input) {
            val first = getFirst(line)
            val second = getLast(line)
            val num = "$first$second".toInt()

            sum += num
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01", "Day01_part2_test")
    check(main(testInput) == 281)

    val input = readInput("Day01", "Day01")

    val startTime = System.currentTimeMillis()
    main(input).println()
    val endTime = System.currentTimeMillis()
    println("Result part 2 time elapsed in milliseconds: ${endTime - startTime}")
}
