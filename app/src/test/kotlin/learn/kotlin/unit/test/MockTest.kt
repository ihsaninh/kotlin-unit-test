package learn.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito

class MockTest {

    @Test
    fun mockTest() {
        val list: List<String> = Mockito.mock(List::class.java) as List<String>

        Mockito.`when`(list[0]).thenReturn("Ihsan")
        Mockito.`when`(list[1]).thenReturn("Amelia")

        assertEquals("Ihsan", list[0])
        assertEquals("Amelia", list[1])
    }
}