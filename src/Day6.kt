import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        val buffer = mutableListOf<Char>()

        var counter = 0

        for (i in 0 until input[0].length) {
            buffer.add(input[0][i])
            counter++

            if (buffer.count() > 4) buffer.removeFirst()
            if (buffer.count() == 4) {
                var isMarker = true

                buffer.toCharArray().forEach { char ->
                    if (buffer.indexOf(char) != buffer.lastIndexOf(char)) isMarker = false
                }

                if (isMarker) break
            }
        }

        return counter
    }

    fun part2(input: List<String>): Int {
        val buffer = mutableListOf<Char>()

        var counter = 0

        for (i in 0 until input[0].length) {
            buffer.add(input[0][i])
            counter++

            if (buffer.count() > 14) buffer.removeFirst()
            if (buffer.count() == 14) {
                var isMarker = true

                buffer.toCharArray().forEach { char ->
                    if (buffer.indexOf(char) != buffer.lastIndexOf(char)) isMarker = false
                }

                if (isMarker) break
            }
        }

        return counter
    }

    val input = getInput(6)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}