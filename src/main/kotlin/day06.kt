package day6

import utils.readInput

fun main() {
    val input = readInput("day06")
    val linesForPart1 = input
        .map { it.split(Regex("\\s+")).filter { it.isNotBlank() }}
    val result1 = part1(linesForPart1)
    println("Result1: ${result1}")
    val result2 = part2(input)
    println("Result2: ${result2}")
}

fun part2(input: List<String>): Long {
    val opLine = input[input.size - 1]
    var currentOp = ' '
    var accum = 0L
    var total = 0L
    for(i in 0 until opLine.length) {
        if (opLine[i] != ' ') {
            total += accum
            currentOp = opLine[i]
            accum = if (currentOp == '+') 0L else 1L
        }
        if (emptyColumn(input, i)) continue
        val value = valueFromColumn(input, i)
        accum = if (currentOp == '+') accum+value else accum*value
    }
    total += accum
    return total
}

fun emptyColumn(input: List<String>, column: Int): Boolean {
    return input.all { it[column] == ' ' }
}
fun valueFromColumn(input: List<String>, column: Int): Long {
    var total = 0L;
    for(i in 0 until input.size -1) {
        if (input[i][column] != ' ') {
            total = 10*total + input[i][column].digitToInt()
        }
    }
    return total
}

fun part1(lines: List<List<String>>): Long {
    var total = 0L
    for(i in 0 until lines[0].size) {
        val op = lines[lines.size - 1][i]
        var accum = if (op == "+") 0L else 1L
        for(j in 0 until lines.size - 1) {
            val value = lines[j][i].toLong()
            accum = if (op == "+") accum+value else accum*value
        }
        total += accum
    }
    return total
}

