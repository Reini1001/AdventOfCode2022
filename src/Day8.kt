@file:Suppress("DuplicatedCode")

import java.io.File


fun array2DInt(dim1: Int, dim2: Int, def: (Int, Int) -> Int = { _, _ -> 0 }): Array<Array<Int>> {
    return Array(dim1) { x ->
        Array(dim2) { y -> def(x, y) }
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        val map: Array<Array<Int>> = array2DInt(input[0].length, input.size)
        val mapVisible: Array<Array<Int>> = array2DInt(input[0].length, input.size)

        for (y in input.indices) {
            val row = input[y].split("").filter { it != "" }
            for (x in row.indices) map[y][x] = row[x].toInt()
        }

        for (y in map.indices) {
            var max = -1
            for (x in map[y].indices) {
                if (map[y][x] > max) {
                    mapVisible[y][x] = 1
                    max = map[y][x]
                }
            }

            max = -1
            for (x in map[y].indices.reversed()) {
                if (map[y][x] > max) {
                    mapVisible[y][x] = 1
                    max = map[y][x]
                }
            }
        }

        for (x in map[0].indices) {
            var max = -1
            for (y in map.indices) {
                if (map[y][x] > max) {
                    mapVisible[y][x] = 1
                    max = map[y][x]
                }
            }

            max = -1
            for (y in map.indices.reversed()) {
                if (map[y][x] > max) {
                    mapVisible[y][x] = 1
                    max = map[y][x]
                }
            }
        }

        return mapVisible.toList().flatMap { it.toList() }.sum()
    }

    fun part2(input: List<String>): Int {
        val map: Array<Array<Int>> = array2DInt(input[0].length, input.size)
        val mapVisibility: Array<Array<Int>> = array2DInt(input[0].length, input.size)

        for (y in input.indices) {
            val row = input[y].split("").filter { it != "" }
            for (x in row.indices) map[y][x] = row[x].toInt()
        }

        for (y in map.indices) {
            for (x in map[y].indices) {
                var left = 0
                var up = 0
                var right = 0
                var down = 0

                var max = map[y][x]
                for (xcl in x - 1 downTo 0) {
                    left++
                    if (map[y][xcl] >= max) break
                }

                for (ycu in y - 1 downTo 0) {
                    up++
                    if (map[ycu][x] >= max) break
                }

                for (xcr in x + 1 until map[y].size) {
                    right++
                    if (map[y][xcr] >= max) break
                }

                for (ycd in y + 1 until map.size) {
                    down++
                    if (map[ycd][x] >= max) break
                }

                mapVisibility[x][y] = left * up * right * down
            }
        }

        return mapVisibility.toList().flatMap { it.toList() }.max()
    }

    val input = getInput(8)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}