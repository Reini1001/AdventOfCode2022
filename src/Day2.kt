import java.io.File

const val OPPONENT_ROCK = "A"
const val OPPONENT_PAPER = "B"
const val OPPONENT_SCISSORS = "C"

const val RESPONSE_ROCK = "X"
const val RESPONSE_PAPER = "Y"
const val RESPONSE_SCISSORS = "Z"

const val ROUND_LOSE = "X"
const val ROUND_DRAW = "Y"
const val ROUND_WIN = "Z"

fun main() {

    fun part1(input: List<String>): Int {
        var score = 0

        input.forEach {
            if (it.contains(RESPONSE_ROCK)) score += 1
            else if (it.contains(RESPONSE_PAPER)) score += 2
            else if (it.contains(RESPONSE_SCISSORS)) score += 3

            if (it.contains(OPPONENT_ROCK)) {
                if (it.contains(RESPONSE_ROCK)) score += 3
                else if (it.contains(RESPONSE_PAPER)) score += 6
                else if (it.contains(RESPONSE_SCISSORS)) score += 0
            } else if (it.contains(OPPONENT_PAPER)) {
                if (it.contains(RESPONSE_ROCK)) score += 0
                else if (it.contains(RESPONSE_PAPER)) score += 3
                else if (it.contains(RESPONSE_SCISSORS)) score += 6
            } else if (it.contains(OPPONENT_SCISSORS)) {
                if (it.contains(RESPONSE_ROCK)) score += 6
                else if (it.contains(RESPONSE_PAPER)) score += 0
                else if (it.contains(RESPONSE_SCISSORS)) score += 3
            }
        }

        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0

        input.forEach {
            if (it.contains(ROUND_LOSE)) score += 0
            else if (it.contains(ROUND_DRAW)) score += 3
            else if (it.contains(ROUND_WIN)) score += 6

            if (it.contains(OPPONENT_ROCK)) {
                if (it.contains(ROUND_LOSE)) score += 3
                else if (it.contains(ROUND_DRAW)) score += 1
                else if (it.contains(ROUND_WIN)) score += 2
            } else if (it.contains(OPPONENT_PAPER)) {
                if (it.contains(ROUND_LOSE)) score += 1
                else if (it.contains(ROUND_DRAW)) score += 2
                else if (it.contains(ROUND_WIN)) score += 3
            } else if (it.contains(OPPONENT_SCISSORS)) {
                if (it.contains(ROUND_LOSE)) score += 2
                else if (it.contains(ROUND_DRAW)) score += 3
                else if (it.contains(ROUND_WIN)) score += 1
            }
        }

        return score
    }

    val input = getInput(2)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}