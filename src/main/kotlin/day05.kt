package day5

import utils.readInput

class FreshState {
    val freshRanges: MutableList<Pair<Long, Long>> = mutableListOf()
    val entries: MutableList<Long> = mutableListOf()
}

fun main() {
    val lines = readInput("day05")
    val state = toFreshState(lines)
    val result1 = part1(state)
    println("Result1: ${result1}")
    val result2 = part2(state.freshRanges)
    println("Result2: ${result2}")
}

fun part1(state: FreshState): Int {
    return state.entries.count { element ->
        state.freshRanges.any { it.first <= element && it.second >= element }
    }
}

fun part2(freshRanges: MutableList<Pair<Long, Long>>): Long {
    var idx1 = 0
    do {
        val currentRange = freshRanges[idx1]
        var acted = false
        for (idx2 in idx1+1 until freshRanges.size) {
            val currentRange2 = freshRanges[idx2]
            if (currentRange.first <= currentRange2.second && currentRange2.first <= currentRange.second) {
                freshRanges[idx1] = Pair(Math.min(currentRange.first, currentRange2.first), Math.max(currentRange.second, currentRange2.second))
                freshRanges.removeAt(idx2)
                acted = true
                break
            }
        }
        if (!acted) idx1++
    } while (idx1 < freshRanges.size)
    return freshRanges.sumOf{it.second - it.first + 1L}
}

fun toFreshState(input: List<String>): FreshState {
    val result = FreshState()
    for(value in input) {
        if (value.indexOf("-") != -1) {
            result.freshRanges.add(Pair(value.split("-")[0].toLong(), value.split("-")[1].toLong()))
        } else if (value != "") {
            result.entries.add(value.toLong())
        }
    }
    return result
}
