@file:Suppress("DuplicatedCode")

import java.io.File

interface Content {
    fun size(): Int
    fun descendants(): List<Content>
}

class File(val name: String, val size: Int) : Content {
    override fun size(): Int {
        return size
    }

    override fun descendants(): MutableList<Content> {
        return mutableListOf(this)
    }
}

class Directory(val name: String, var parent: Directory?, var children: MutableMap<String, Content>) : Content {
    override fun size(): Int {
        return children.values.sumOf { it.size() }
    }

    override fun descendants(): MutableList<Content> {
        return (listOf(this) + children.values.flatMap { it.descendants() }).toMutableList()
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        val root = Directory("/", null, mutableMapOf())
        root.parent = root
        var currentDirectory = root

        input.forEach { line ->
            val lineParts = line.split(" ")

            when (lineParts[0]) {
                "$" -> {
                    when (lineParts[1]) {
                        "cd" -> {
                            when (lineParts[2]) {
                                "/" -> {
                                    currentDirectory = root
                                }

                                ".." -> {
                                    currentDirectory = currentDirectory.parent!!
                                }

                                else -> {
                                    currentDirectory = currentDirectory.children[lineParts[2]] as Directory
                                }
                            }
                        }

                        "ls" -> {
                            return@forEach
                        }
                    }
                }

                "dir" -> {
                    currentDirectory.children[lineParts[1]] = Directory(lineParts[1], currentDirectory, mutableMapOf())
                }

                else -> {
                    currentDirectory.children[lineParts[1]] = File(lineParts[1], lineParts[0].toInt())
                }
            }
        }

        return root.descendants().filterIsInstance<Directory>().map { it.size() }.filter { it <= 100000 }.sum()
    }

    fun part2(input: List<String>): Int {
        val root = Directory("/", null, mutableMapOf())
        root.parent = root
        var currentDirectory = root

        input.forEach { line ->
            val lineParts = line.split(" ")

            when (lineParts[0]) {
                "$" -> {
                    when (lineParts[1]) {
                        "cd" -> {
                            when (lineParts[2]) {
                                "/" -> {
                                    currentDirectory = root
                                }

                                ".." -> {
                                    currentDirectory = currentDirectory.parent!!
                                }

                                else -> {
                                    currentDirectory = currentDirectory.children[lineParts[2]] as Directory
                                }
                            }
                        }

                        "ls" -> {
                            return@forEach
                        }
                    }
                }

                "dir" -> {
                    currentDirectory.children[lineParts[1]] = Directory(lineParts[1], currentDirectory, mutableMapOf())
                }

                else -> {
                    currentDirectory.children[lineParts[1]] = File(lineParts[1], lineParts[0].toInt())
                }
            }
        }

        val totalSpace = 70_000_000
        val neededSpace = 30_000_000

        val usedSpace = root.size()

        val freeSpace = totalSpace - usedSpace
        val minRemoveSpace = neededSpace - freeSpace

        return root.descendants().filterIsInstance<Directory>().map { it.size() }.filter { it >= minRemoveSpace }.min()
    }

    val input = getInput(7)
    println("Part One: " + part1(input))
    println("Part Two: " + part2(input))
}