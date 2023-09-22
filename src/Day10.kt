import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        var cycle = 0
        var x = 1

        var signalStrengths = 0

        fun doCycle(count: Int = 1) {
            for (i in 0 until count) {
                cycle += 1
                if ((cycle + 20) % 40 == 0) {
                    signalStrengths += x * cycle
                }
            }
        }

        input.forEach { line ->
            val command = line.split(" ")

            when (command[0]) {
                "addx" -> {
                    doCycle(2)
                    x += command[1].toInt()
                }

                "noop" -> doCycle()
                else -> println("command default!")
            }
        }

        return signalStrengths
    }

    fun part2(input: List<String>): Int {
        var cycle = 0
        var x = 1

        fun doCycle(count: Int = 1) {
            for (i in 0 until count) {
                if (cycle % 40 in x - 1..x + 1) {
                    print("##")
                } else print("..")

                cycle += 1

                if (cycle % 40 == 0) {
                    println("")
                }
            }
        }

        input.forEach { line ->
            val command = line.split(" ")

            when (command[0]) {
                "addx" -> {
                    doCycle(2)
                    x += command[1].toInt()
                }

                "noop" -> doCycle()
                else -> println("command default!")
            }
        }

        return 0
    }

    val input = getInput(10)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}