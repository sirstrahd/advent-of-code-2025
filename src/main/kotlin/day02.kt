package day2

import utils.readInput

private fun getMovements(input: List<String>): List<Pair<Long, Long>> {
    return input.map { Pair(it.split("-")[0].toLong(), it.split("-")[1].toLong())}
}

fun part1(input: List<String>): Long {
    var total = 0L
    val ranges = getMovements(input)
    for (range in ranges) {
        var current = range.first
        while (current <= range.second) {
            val currentString = current.toString();
            val firstHalf = currentString.take(currentString.length / 2)
            val secondHalf = currentString.drop(currentString.length / 2)
            if (firstHalf == secondHalf) {
                total += current
                println("Found matching number: ${current}")
            }
            current++
        }
    }
    return total
}

fun part2(input: List<String>): Long {
    var total = 0L
    val ranges = getMovements(input)
    for (range in ranges) {
        var current = range.first
        while (current <= range.second) {
            val currentString = current.toString();
            var len = 1;
            while(len <= currentString.length / 2) {
                val pattern = currentString.take(len)
                var restOfString = currentString;
                do {
                    restOfString = restOfString.drop(len)
                } while ((restOfString.startsWith(pattern)));
                if (restOfString.isEmpty()) {
                    total += current
                    println("Found matching number: ${current}")
                    break;
                }
                len++
            }
            current++
        }
    }
    return total
}

fun main() {
    val testInput = readInput("day02")[0].split(",");
    // 7243 too high
    val result1 = part2(testInput)
    println("Result1: ${result1}")

}