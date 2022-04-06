package learn.kotlin.unit.test

import org.junit.jupiter.api.*
import org.junit.jupiter.api.condition.*

class ConditionalTest {

    @Test
    @EnabledOnOs(value = [OS.WINDOWS, OS.LINUX])
    fun enabledOnWindowsOrLinux() {
        // Only run on Windows or Linux
    }

    @Test
    @DisabledOnOs(value = [OS.WINDOWS])
    fun disabledOnWindows() {
        // can not run on Windows
    }

    @Test
    @EnabledOnJre(value = [JRE.JAVA_17])
    fun onlyRunOnJava17() {
        // Only run on JAVA 17
    }

    @Test
    @DisabledOnJre(value = [JRE.JAVA_17])
    fun disabledRunOnJava17() {
        // cat not run on JAVA 17
    }

    @Test
    fun printSystemProperties() {
        System.getProperties().forEach { key, value  ->
            println("$key => $value")
        }
    }

    @Test
    @EnabledIfSystemProperties(value = [
        EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun enabledOnOracle() {

    }

    @Test
    @DisabledIfSystemProperties(value = [
        DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun disabledOnOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "Profile", matches = "DEV")
    fun enabledOnDev() {

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "Profile", matches = "DEV")
    fun disabledOnDev() {

    }

}