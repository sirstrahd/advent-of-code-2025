package day1

import utils.readInput

private fun getMovements(input: List<String>): List<Int> {
    return input.map { line ->
        val distance = line.substring(1).toInt()
        if (line.first() == 'L') {
            -distance
        } else {
            distance
        }
    }
}

fun part1(input: List<String>): Int {
    var position = 50
    var counter = 0
    val movs = getMovements(input)
    for (mov in movs) {
        position = (position + mov) % 100
        if (position == 0) counter++
    }
    return counter
}

fun part2(input: List<String>, initialPosition: Int = 50): Int {
    var position = initialPosition
    var counter = 0
    val movs = getMovements(input)
    for (mov in movs) {
        if (mov < 0) position = (100 - position) % 100
        position = (position + Math.abs(mov))
        counter+= (position / 100)
        position %= 100
        if (mov < 0) position = (100 - position) % 100
    }
    return counter
}

fun main() {
    val testInput = readInput("Day01")
    val result1 = part2(testInput)
    println("Result1: ${result1}")

}