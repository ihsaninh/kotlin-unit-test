package learn.kotlin.unit.test

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class NestedClass {

    @Test
    fun test1() {

    }

    @Nested
    inner class MyNesterTest {

        @Test
        fun test1() {

        }
    }
}