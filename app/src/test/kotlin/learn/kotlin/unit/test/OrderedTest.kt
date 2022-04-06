package learn.kotlin.unit.test

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
class OrderedTest {

    private var counter: Int = 0

    @BeforeAll
    fun beforeAll() {

    }

    @AfterAll
    fun afterAll() {

    }

    @Test
    @Order(3)
    fun test3() {
        counter++
        println(counter)
    }

    @Test
    @Order(2)
    fun test2() {
        counter++
        println(counter)
    }

    @Test
    @Order(1)
    fun test1() {
        counter++
        println(counter)
    }
}