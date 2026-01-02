package day7

import utils.readInput
import kotlin.collections.mutableMapOf

fun main() {
    val input = readInput("day07").map{it.toCharArray()}
    val result1 = part1(input)
    println("Result1: ${result1}")
    val result2 = part2(input)
    println("Result2: ${result2}")
}

fun part1(input: List<CharArray>): Long {
    var splitCount = 0L
    for(i in 1 until input.size) {
        for (j in 0 until input[i].size) {
            if (input[i-1][j] == 'S') {
                if (input[i][j] == '^') {
                    splitCount++;
                    if (j-1 >= 0) {
                        input[i][j-1] = 'S'
                    }
                    if (j+1 < input[i].size) {
                        input[i][j+1] = 'S'
                    }
                } else {
                    input[i][j] = 'S'
                }
            }
        }
    }
    return splitCount
}

fun part2(input: List<CharArray>): Long {
    val cache = mutableMapOf<Pair<Int, Int>, Long>()
    return recursivePart2(input, input[0].indexOf('S'), 0, cache)
}

fun recursivePart2(input: List<CharArray>, x: Int, y: Int, cache: MutableMap<Pair<Int, Int>, Long>): Long {
    if (y >= input.size) return 1L
    if (x < 0 || x >= input[y].size) return 0L
    if (input[y][x] == '^') {
        if (cache.containsKey(Pair(x,y))) return cache[Pair(x,y)]!!
        val calculatedValue = recursivePart2(input, x-1, y, cache ) + recursivePart2(input, x+1, y, cache )
        cache[Pair(x,y)] = calculatedValue
        return calculatedValue
    } else {
        return recursivePart2(input, x, y+1, cache)
    }
}
