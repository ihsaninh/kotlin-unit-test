package learn.kotlin.unit.test.resolver

import learn.kotlin.unit.test.Calculator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

@Extensions(value = [
    ExtendWith(RandomParameterResolver::class)
])
abstract class ParentCalculatorTest {
    protected val calculator = Calculator()

    @BeforeEach
    fun beforeEach() {
        println("Before Each")
    }
}