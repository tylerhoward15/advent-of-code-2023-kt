@file:JvmName("Day02_part2Kt")

package Day02

import println
import readInput

fun main() {
    fun main(input: List<String>): Int {
        return input.sumOf {
            (it.first { it.isDigit() }.digitToInt() * 10) + (it.last { it.isDigit() }.digitToInt())
        }

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01", "Day01_part1_test")
    check(main(testInput) == 142)

    val input = readInput("Day01", "Day01")

    val startTime = System.currentTimeMillis()
    main(input).println()
    val endTime = System.currentTimeMillis()
    println("Time elapsed in milliseconds: ${endTime - startTime}")
}
