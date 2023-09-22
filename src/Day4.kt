import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        var count = 0

        input.forEach { pair ->
            val sectionAssignments = pair.split(",")
            val sections = mutableListOf<List<Int>>()

            sectionAssignments.forEach { sectionAssignment ->
                val sectionValues = sectionAssignment.split("-")
                sections.add(sectionValues[0].toInt().rangeTo(sectionValues[1].toInt()).toList())
            }

            if (sections[0].containsAll(sections[1]) || sections[1].containsAll(sections[0])) count++

        }

        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0

        input.forEach { pair ->
            val sectionAssignments = pair.split(",")
            val sections = mutableListOf<List<Int>>()

            sectionAssignments.forEach { sectionAssignment ->
                val sectionValues = sectionAssignment.split("-")
                sections.add(sectionValues[0].toInt().rangeTo(sectionValues[1].toInt()).toList())
            }

            val intersection = sections[0].intersect(sections[1].toSet())

            if (intersection.isNotEmpty()) count++

        }

        return count
    }

    val input = getInput(4)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}