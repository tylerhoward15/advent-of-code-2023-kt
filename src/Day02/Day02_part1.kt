package Day02

import println
import readInput


val maxValues = mapOf(
    "red" to 12,
    "blue" to 14,
    "green" to 13,
)

data class GameMatch(val gameMatchString: String, val id: Int = getId(gameMatchString)) {
    companion object {
        private fun getId(gameString: String): Int {
            val regex = "Game (\\d+):".toRegex()
            val match = regex.find(gameString) ?: throw Exception("Game id could not found")

            val id = match.groupValues[1].toInt()

            return id
        }
    }

    fun score(): Int {
        if (isValid()) return id

        return 0
    }

    private fun isValid(): Boolean {
        val gameSets = getGameSets()
        gameSets.forEach {
            val colorCounts = it.split(',')
            colorCounts.forEach {
                val regex = "(\\d+) (\\w+)".toRegex()
                val match = regex.find(it) ?: throw Exception("No color count combo could be found")

                val count = match.groupValues[1].toInt()
                val color = match.groupValues[2].trim()

                val maxVal = maxValues[color]?.toInt() ?: Int.MAX_VALUE
                if (count > maxVal) return false
            }
        }

        return true
    }

    private fun getGameSets(): List<String> {
        val regex = "Game (\\d+):(.*)(?:;|\$)".toRegex()
        val match = regex.find(gameMatchString) ?: throw Exception("No game contents could be found.")

        return match.groupValues[2].split(';')
    }
}


fun run(input: List<String>): Int {
    return input.sumOf {
        val gameMatch = GameMatch(it)
        gameMatch.score()
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
