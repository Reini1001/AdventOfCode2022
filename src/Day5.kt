import java.io.File

fun main() {
    fun part1(input: List<String>): String {
        val stacks = listOf(
            mutableListOf("D", "T", "R", "B", "J", "L", "W", "G"),
            mutableListOf("S", "W", "C"),
            mutableListOf("R", "Z", "T", "M"),
            mutableListOf("D", "T", "C", "H", "S", "P", "V"),
            mutableListOf("G", "P", "T", "L", "D", "Z"),
            mutableListOf("F", "B", "R", "Z", "J", "Q", "C", "D"),
            mutableListOf("S", "B", "D", "J", "M", "F", "T", "R"),
            mutableListOf("L", "H", "R", "B", "T", "V", "M"),
            mutableListOf("Q", "P", "D", "S", "V")
        )

        input.filter { it.contains("move") }.forEach {
            val numbers = it.split(" ")
                .filterNot { split -> split.contains("move") || split.contains("from") || split.contains("to") }

            for (i in 1..numbers[0].toInt()) {
                stacks[numbers[2].toInt() - 1].add(stacks[numbers[1].toInt() - 1].removeLast())
            }
        }

        var out = ""

        stacks.forEach {
            out += it.removeLast()
        }

        return out
    }

    fun part2(input: List<String>): String {
        val stacks = listOf(
            mutableListOf("D", "T", "R", "B", "J", "L", "W", "G"),
            mutableListOf("S", "W", "C"),
            mutableListOf("R", "Z", "T", "M"),
            mutableListOf("D", "T", "C", "H", "S", "P", "V"),
            mutableListOf("G", "P", "T", "L", "D", "Z"),
            mutableListOf("F", "B", "R", "Z", "J", "Q", "C", "D"),
            mutableListOf("S", "B", "D", "J", "M", "F", "T", "R"),
            mutableListOf("L", "H", "R", "B", "T", "V", "M"),
            mutableListOf("Q", "P", "D", "S", "V")
        )

        input.filter { it.contains("move") }.forEach {
            val numbers = it.split(" ")
                .filterNot { split -> split.contains("move") || split.contains("from") || split.contains("to") }

            val tmp = mutableListOf<String>()

            for (i in 1..numbers[0].toInt()) {
                tmp.add(stacks[numbers[1].toInt() - 1].removeLast())
            }

            for (i in 0 until tmp.count()) {
                stacks[numbers[2].toInt() - 1].add(tmp.removeLast())
            }
        }

        var out = ""

        stacks.forEach {
            out += it.removeLast()
        }

        return out
    }

    val input = getInput(5)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}