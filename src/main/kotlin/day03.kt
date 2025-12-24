package day3

import utils.readInput

fun part1(input: List<String>): Long {
    var total = 0L
    for (line in input) {
        var maxLeft = 0;
        var maxRight = 0;
        for(current in line.map { it.digitToInt()}) {
            if (maxRight > maxLeft) {
                maxLeft = maxRight;
                maxRight = current;
            } else if (current > maxRight) {
                maxRight = current;
            }
        }
        val valueForLine = maxLeft*10 + maxRight;
        println("total is ${valueForLine}")
        total += valueForLine
    }
    return total
}

fun part2(input: List<String>): Long {
    var total = 0L
    for (line in input) {
        total += processPart2Line(line)
    }
    return total
}

fun processPart2Line(line: String): Long {
    var previousValue = 0L;
    println(line)
    val digitLine = line.map { it.digitToInt() }
    val maxDetectedSoFar = digitLine.subList(0, 12).toMutableList()
    for (nextDigit in 12..<digitLine.size) {
        var currentIndex = 0;
        while (currentIndex < 11) {
            if (maxDetectedSoFar[currentIndex] < maxDetectedSoFar[currentIndex + 1]) {
                for (i in currentIndex..<maxDetectedSoFar.size - 1) {
                    maxDetectedSoFar[i] = maxDetectedSoFar[i + 1]
                }
                maxDetectedSoFar[11] = digitLine[nextDigit]
                break;
            } else {
                currentIndex++
            }
        }
        if (currentIndex == 11) {
            if (maxDetectedSoFar[11] < digitLine[nextDigit]) {
                maxDetectedSoFar[11] = digitLine[nextDigit]
            }
        }
        println(maxDetectedSoFar)
    }
    if (previousValue > toNumber(maxDetectedSoFar)) {
        println("oops! ${previousValue} is bigger than ${toNumber(maxDetectedSoFar)}")
        throw Exception("oops!")
    }
    return toNumber(maxDetectedSoFar)
}

private fun toNumber(maxDetectedSoFar: MutableList<Int>): Long = maxDetectedSoFar.fold(0L) { acc, i -> acc * 10L + i }

fun main() {
    val testInput = readInput("day03")
    val result1 = part2(testInput)
    println("Result1: ${result1}")

}