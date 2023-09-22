import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        var headPosition = Pair(0, 0)
        var tailPosition = Pair(0, 0)

        val visited: MutableList<Pair<Int, Int>> = mutableListOf(tailPosition)

        input.forEach { line ->
            val move = line.split(" ")

            for (i in 0 until move[1].toInt()) {
                val lastAnkerPosition = headPosition

                when (move[0]) {
                    "L" -> headPosition = Pair(headPosition.first - 1, headPosition.second)
                    "U" -> headPosition = Pair(headPosition.first, headPosition.second + 1)
                    "R" -> headPosition = Pair(headPosition.first + 1, headPosition.second)
                    "D" -> headPosition = Pair(headPosition.first, headPosition.second - 1)
                }

                if (!(headPosition.first == tailPosition.first && headPosition.second == tailPosition.second ||
                            headPosition.first == tailPosition.first - 1 && headPosition.second == tailPosition.second ||
                            headPosition.first == tailPosition.first - 1 && headPosition.second == tailPosition.second + 1 ||
                            headPosition.first == tailPosition.first && headPosition.second == tailPosition.second + 1 ||
                            headPosition.first == tailPosition.first + 1 && headPosition.second == tailPosition.second + 1 ||
                            headPosition.first == tailPosition.first + 1 && headPosition.second == tailPosition.second ||
                            headPosition.first == tailPosition.first + 1 && headPosition.second == tailPosition.second - 1 ||
                            headPosition.first == tailPosition.first && headPosition.second == tailPosition.second - 1 ||
                            headPosition.first == tailPosition.first - 1 && headPosition.second == tailPosition.second - 1)
                ) {
                    tailPosition = lastAnkerPosition
                    if (!visited.contains(tailPosition)) visited.add(tailPosition)
                }
            }
        }

        return visited.size
    }

    fun part2(input: List<String>): Int {
        val ropePositions = mutableListOf(
            Pair(0, 0), Pair(0, 0), Pair(0, 0),
            Pair(0, 0), Pair(0, 0), Pair(0, 0),
            Pair(0, 0), Pair(0, 0), Pair(0, 0), Pair(0, 0)
        )

        val visited: MutableList<Pair<Int, Int>> = mutableListOf(ropePositions[ropePositions.size - 1])

        input.forEach { line ->
            val move = line.split(" ")

            for (k in 0 until move[1].toInt()) {
                var lastPosition = ropePositions[0]

                when (move[0]) {
                    "L" -> ropePositions[0] = Pair(ropePositions[0].first - 1, ropePositions[0].second)
                    "U" -> ropePositions[0] = Pair(ropePositions[0].first, ropePositions[0].second + 1)
                    "R" -> ropePositions[0] = Pair(ropePositions[0].first + 1, ropePositions[0].second)
                    "D" -> ropePositions[0] = Pair(ropePositions[0].first, ropePositions[0].second - 1)
                }

                for (i in 1 until ropePositions.size) {
                    if (!(ropePositions[i - 1].first == ropePositions[i].first && ropePositions[i - 1].second == ropePositions[i].second ||
                                ropePositions[i - 1].first == ropePositions[i].first - 1 && ropePositions[i - 1].second == ropePositions[i].second ||
                                ropePositions[i - 1].first == ropePositions[i].first - 1 && ropePositions[i - 1].second == ropePositions[i].second + 1 ||
                                ropePositions[i - 1].first == ropePositions[i].first && ropePositions[i - 1].second == ropePositions[i].second + 1 ||
                                ropePositions[i - 1].first == ropePositions[i].first + 1 && ropePositions[i - 1].second == ropePositions[i].second + 1 ||
                                ropePositions[i - 1].first == ropePositions[i].first + 1 && ropePositions[i - 1].second == ropePositions[i].second ||
                                ropePositions[i - 1].first == ropePositions[i].first + 1 && ropePositions[i - 1].second == ropePositions[i].second - 1 ||
                                ropePositions[i - 1].first == ropePositions[i].first && ropePositions[i - 1].second == ropePositions[i].second - 1 ||
                                ropePositions[i - 1].first == ropePositions[i].first - 1 && ropePositions[i - 1].second == ropePositions[i].second - 1)
                    ) {
                        val tempPosition = ropePositions[i]
                        ropePositions[i] = lastPosition
                        if (i >= ropePositions.size - 1 && !visited.contains(ropePositions[i])) visited.add(
                            ropePositions[i]
                        )
                        lastPosition = tempPosition
                    }
                }

//                for (y in 16 downTo -6) {
//                    for (x in -12 until 16) {
//                        when (Pair(x, y)) {
//                            ropePositions[0] -> print("H")
//                            ropePositions[1] -> print("1")
//                            ropePositions[2] -> print("2")
//                            ropePositions[3] -> print("3")
//                            ropePositions[4] -> print("4")
//                            ropePositions[5] -> print("5")
//                            ropePositions[6] -> print("6")
//                            ropePositions[7] -> print("7")
//                            ropePositions[8] -> print("8")
//                            ropePositions[9] -> print("9")
//                            Pair(0, 0) -> print("s")
//                            in visited -> print("#")
//                            else -> print(".")
//                        }
//                    }
//                    println()
//                }
//                println()
            }
        }

        return visited.size
    }

    val input = getInput(9)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}