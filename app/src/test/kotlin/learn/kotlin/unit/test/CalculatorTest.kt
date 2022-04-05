package learn.kotlin.unit.test

import learn.kotlin.unit.test.generator.SimpleDisplayNameGenerator
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.opentest4j.TestAbortedException
import org.junit.jupiter.api.Assumptions.*

@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
// @DisplayName("Test for calculator class")
class CalculatorTest {
    private val calculator = Calculator()

    companion object {

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("Before All Unit Test")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("After All Unit Test")
        }
    }

    @BeforeEach
    fun beforeEach() {
        println("Before Unit Test")
    }

    @AfterEach
    fun afterEach() {
        println("After Unit Test")
    }

    @Test
    // @DisplayName("Test for function Calculator.add(10, 10)")
    fun testAddSuccess() {
        println("Unit test testAddSuccess")
        val result = calculator.add(10, 10)
        assertEquals(20, result, "Hasil harusnya 20")
    }

    @Test
    // @DisplayName("Test for function Calculator.add(10, 20)")
    fun testAddSuccess2() {
        println("Unit test testAddSuccess2")
        val result = calculator.add(10, 20)
        assertEquals(30, result, "Hasil harusnya 30")
    }

    @Test
    fun testDivideSuccess() {
        println("Unit test testDivideSuccess")
        val result = calculator.divide(100, 10)
        assertEquals(10, result, "Hasil harusnya 10")
    }

    @Test
    fun testDivideError() {
        println("Unit test testDivideError")
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }
    }

    @Disabled("Not yet implemented")
    @Test
    fun testCommingSoon() {
        // not yet implemented
    }

    @Test
    fun testAborted() {
        val profile = System.getenv()["Profile"]
        if ("DEV" != profile) {
            throw TestAbortedException()
        }

        println("Test not aborted because dev profile")
    }

    @Test
    fun testAssumption() {
        assumeTrue("DEV" == System.getenv()["Profile"])

        println("Test not aborted because dev profile")
    }
}