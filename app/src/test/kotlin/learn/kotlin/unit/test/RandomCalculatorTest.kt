package learn.kotlin.unit.test

import learn.kotlin.unit.test.resolver.ParentCalculatorTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.Random

class RandomCalculatorTest : ParentCalculatorTest() {

    @DisplayName("Test with parameter")
    @ParameterizedTest(
        name = "{displayName} with data {0}"
    )
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun testWithParameter(value: Int) {
        val result = calculator.add(value, value)
        assertEquals(value + value, result)
    }

    @Test
    fun testRandom(random: Random) {
        val first = random.nextInt(1000)
        val second = random.nextInt(1000)

        val result = calculator.add(first, second)

        assertEquals(first + second, result)
    }

    @DisplayName("Test Calculator Random")
    @RepeatedTest(
        value = 10,
        name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    fun testRandomRepeated(random: Random, repetitionInfo: RepetitionInfo, testInfo: TestInfo) {
        println("${testInfo.displayName} ke ${repetitionInfo.currentRepetition} dari ${repetitionInfo.totalRepetitions}")
        val first = random.nextInt(1000)
        val second = random.nextInt(1000)

        val result = calculator.add(first, second)

        assertEquals(first + second, result)
    }

    @ParameterizedTest
    @MethodSource(value = ["parameterSource"])
    fun testWithMethodSource(value: Int) {
        assertEquals(value + value, calculator.add(value, value))
    }

    companion object {

        @JvmStatic
        fun parameterSource(): List<Int> {
            return listOf(1, 2, 3, 4, 5)
        }
    }
}