package day4

import utils.readInput

fun adjacents(x: Int, y: Int): List<Pair<Int, Int>> {
    return listOf(Pair(x-1,y), Pair(x+1,y), Pair(x,y-1), Pair(x,y+1), Pair(x-1,y-1), Pair(x-1,y+1), Pair(x+1,y-1), Pair(x+1,y+1))
}

fun part1(input:  MutableMap<Pair<Int, Int>, Int>): Long {
    input.keys.forEach { key ->
        input[key] = adjacents(key.first, key.second).count { input[it] != null }
    }
    return input.entries.count { it.value < 4 }.toLong()
}

fun part2(input: MutableMap<Pair<Int, Int>, Int>): Long {
    val originalSize = input.size
    var removableEntries: List<Pair<Int, Int>>
    do {
        input.keys.forEach { key ->
            input[key] = adjacents(key.first, key.second).count { input[it] != null }
        }
        removableEntries = input.entries.filter { it.value < 4 }.map { it.key}
        removableEntries.forEach { input.remove(it) }
    } while (removableEntries.isNotEmpty())
    return (originalSize - input.size).toLong()
}

fun getBoxes(lines: List<String>): MutableMap<Pair<Int, Int>, Int> {
    val output = mapOf<Pair<Int,Int>,Int>().toMutableMap()
    lines.forEachIndexed { indexY, line -> line.forEachIndexed { indexX, ch -> if (ch == '@') output[Pair(indexX,indexY)] = 0 }}
    return output
}

fun main() {
    val lines = readInput("day04")
    val map = getBoxes(lines)
    val result1 = part1(map)
    val result2 = part2(map)
    println("Result1: ${result1}")
    println("Result2: ${result2}")
}