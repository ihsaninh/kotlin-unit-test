package learn.kotlin.unit.test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo

@DisplayName("Test with test info")
class InformationTest {
    @Test
    @Tag("cool")
    @DisplayName("This is test one")
    fun testOne(testInfo: TestInfo) {
        println(testInfo.displayName)
        println(testInfo.tags)
        println(testInfo.testMethod)
        println(testInfo.testClass)
    }

}