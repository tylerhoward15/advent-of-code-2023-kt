package Day02

import println
import readInput

fun main() {
    fun getId(game: String): Int? {
        val regex = "Game (\\d+):".toRegex()
        val match = regex.find(game)
        val id = match?.let{ it.groupValues[1].toInt() }

        return id
    }

    fun isValid(game: String): Boolean {
        val regex = "Game (\\d+):(.*)(?:;|\$)".toRegex()
        val match = regex.find(game)
        println(match?.let { it.groupValues[2].trim() })

        return true
    }

    fun score(game: String): Int? {
        if (isValid(game)) return getId(game)
    }

    fun main(input: List<String>): Int {
        return input.sumOf {
            score(it) ?: 0
        }

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02", "Day02_part1_test")
    val testOutput = main(testInput)
    check(testOutput == 8) { "Returned $testOutput" }

    val input = readInput("Day02", "Day02")

    main(input).println()
}
