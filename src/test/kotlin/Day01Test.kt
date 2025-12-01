import day1.part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun test1() {
        val input = listOf("L550")
        assertEquals(6, part2(input))
    }

    @Test
    fun test2() {
        val input = listOf("R550")
        assertEquals(6, part2(input))
    }

    @Test
    fun test3() {
        val input = listOf("L500")
        assertEquals(5, part2(input))
    }

    @Test
    fun test4() {
        val input = listOf("L10000")
        assertEquals(100, part2(input))
    }

    @Test
    fun test5() {
        val input = listOf("L50","R50")
        assertEquals(1, part2(input))
    }

    @Test
    fun test6() {
        val input = listOf("L50","R150")
        assertEquals(2, part2(input))
    }

    @Test
    fun test7() {
        val input = listOf("L50","R200")
        assertEquals(3, part2(input))
    }

    @Test
    fun test8() {
        val input = listOf("L50")
        assertEquals(0, part2(input,0))
    }

}