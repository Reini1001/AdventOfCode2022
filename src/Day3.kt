import java.io.File

fun main() {

    val priority = mutableMapOf<Char, Int>()

    var i = 1
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray().forEach {
        priority[it] = i
        i++
    }

    fun part1(input: List<String>): Int {
        var sumOfPriorities = 0

        input.forEach { backpack ->
            val mid = backpack.length / 2
            val firstHalf = backpack.substring(0, mid)
            val secondHalf = backpack.substring(mid)

            val intersection = firstHalf.toCharArray().intersect(secondHalf.toCharArray().asIterable().toSet())

            intersection.forEach { item ->
                sumOfPriorities += priority.getOrDefault(item, 0)
            }
        }

        return sumOfPriorities
    }

    fun part2(input: List<String>): Int {
        var sumOfPriorities = 0

        val groups = input.chunked(3)

        groups.forEach { group ->
            val badge = group[0].toCharArray()
                .intersect(group[1].toCharArray().intersect(group[2].toCharArray().asIterable().toSet())).toList()[0]
            sumOfPriorities += priority.getOrDefault(badge, 0)
        }

        return sumOfPriorities
    }

    val input = getInput(3)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}