package learn.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.TimeUnit

@Execution(ExecutionMode.CONCURRENT)
class SlowTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun slowTest() {
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun slowTest2() {
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun slowTest3() {
        Thread.sleep(3000)
    }
}