package Day02

import println
import readInput

fun getId(game: String): Int {
    val regex = "Game (\\d+):".toRegex()
    val match = regex.find(game)
    if (match == null) {
        throw Exception("No game id could be found.")
    }

    val id = match.groupValues[1].toInt()

    return id
}

fun isValid(game: String): Boolean {
    val regex = "Game (\\d+):(.*)(?:;|\$)".toRegex()
    val match = regex.find(game)
    if (match == null) {
        throw Exception("No game contents could be found.")
    }
    println(match.groupValues[2].trim())

    return true
}

fun score(game: String): Int {
    if (isValid(game)) return getId(game)

    return 0
}

fun run(input: List<String>): Int {
    return input.sumOf {
        score(it)
    }

}

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02", "Day02_part1_test")
    val testOutput = run(testInput)
    check(testOutput == 8) { "Returned $testOutput" }

    val input = readInput("Day02", "Day02")

    run(input).println()
}
