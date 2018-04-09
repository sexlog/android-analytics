package br.com.esapiens.analytics

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

/**
 * Created by esapiens on 09/04/18.
 */
class LogAnalyticsServiceTests {
    @Test
    fun testCall() {
        val analytics = Analytics()

        val logOutput: (String) -> Unit = mock()
        val logAnalyticsService = LogAnalyticsService(logOutput)
        analytics.addService(logAnalyticsService)

        val testEvent = TestEvent().also { it.numberOfClicks = 10 }

        analytics.send(testEvent)

        verify(logOutput, times(1)).invoke("Event: ${testEvent.name}")
        verify(logOutput, times(1)).invoke(testEvent.getMapForTestingPurposes().toString())
    }
}