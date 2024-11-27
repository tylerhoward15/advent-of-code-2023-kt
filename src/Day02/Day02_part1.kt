package Day02

import println
import readInput

data class Game(val gameString: String, val id: Int = getId(gameString)) {
    companion object {
        private fun getId(gameString: String): Int {
            val regex = "Game (\\d+):".toRegex()
            val match = regex.find(gameString)
            if (match == null) {
                throw Exception("No game id could be found.")
            }

            val id = match.groupValues[1].toInt()

            return id
        }
    }

    fun score(): Int {
        if (isValid()) return id

        return 0
    }

    private fun isValid(): Boolean {
        val regex = "Game (\\d+):(.*)(?:;|\$)".toRegex()
        val match = regex.find(gameString)
        if (match == null) {
            throw Exception("No game contents could be found.")
        }
        println(match.groupValues[2].trim())

        return true
    }
}


fun run(input: List<String>): Int {
    return input.sumOf {
        val game = Game(it)
        game.score()
    }
}


fun main(args: Array<String>) {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02", "Day02_part1_test")
    val testOutput = run(testInput)
    check(testOutput == 8) { "Returned $testOutput" }

    val input = readInput("Day02", "Day02")

    run(input).println()
}
