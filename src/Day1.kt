fun main() {
    fun part1(input: List<String>): Int {
        var lastValue = 0
        var currentValue = 0

        input.forEach {
            if (it == "") {
                if (currentValue > lastValue) lastValue = currentValue
                currentValue = 0
            } else {
                currentValue += it.toInt()
            }
        }

        return currentValue.coerceAtLeast(lastValue)
    }

    fun part2(input: List<String>): Int {
        val listOfCalorieSums: MutableList<Int> = mutableListOf()
        var currentValue = 0

        input.forEach {
            if (it == "") {
                listOfCalorieSums.add(currentValue)
                currentValue = 0
            } else {
                currentValue += it.toInt()
            }
        }

        listOfCalorieSums.sortDescending()

        return listOfCalorieSums.take(3).sum()
    }

    val input = getInput(1)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}