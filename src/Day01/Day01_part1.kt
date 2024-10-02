package Day01

import println
import readInput

fun main() {
    fun main(input: List<String>): Int {
        val nums = input.map { it.filter { it.isDigit() } }
        val ret = nums.filter { it.isNotEmpty() }.map { "${it.firstOrNull()}${it.lastOrNull()}" }.map { it.toInt() }
            .reduceOrNull { a,b -> a + b }!!

        return ret
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01", "Day01_part1_test")
    check(main(testInput) == 142)

    val input = readInput("Day01", "Day01")
    main(input).println()
}
