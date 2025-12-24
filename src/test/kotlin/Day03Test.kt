import day1.part2
import day3.processPart2Line
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun test1() {
        val input = "6176285753884783858418667873518845351176428121716461628338383814863224888357559"
        assertEquals(888888888889L, processPart2Line(input))
    }

}