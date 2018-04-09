package br.com.esapiens.analytics

import com.nhaarman.mockito_kotlin.*
import org.junit.Test

/**
 * Created by esapiens on 09/04/18.
 */
class AnalyticsTests {
    @Test
    fun testAdd() {
        val analytics = Analytics()
        val mockedAnalyticsService = mock<AnalyticsService>()
        analytics.addService(mockedAnalyticsService)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun testAddSimilar() {
        val analytics = Analytics()
        val mockedAnalyticsService1 = mock<AnalyticsService>()
        analytics.addService(mockedAnalyticsService1)
        val mockedAnalyticsService2 = mock<AnalyticsService>()
        analytics.addService(mockedAnalyticsService2)
    }

    @Test
    fun testRemove() {
        val analytics = Analytics()
        val mockedAnalyticsService = mock<AnalyticsService>()
        analytics.addService(mockedAnalyticsService)
        analytics.removeService(mockedAnalyticsService)
    }

    @Test
    fun testSend() {
        val testEvent = TestEvent().also { it.numberOfClicks = 10 }
        val analytics = spy(Analytics())

        val mockedAnalyticsService = mock<AnalyticsService>()
        analytics.addService(mockedAnalyticsService)

        analytics.send(testEvent)

        verify(mockedAnalyticsService, times(1)).send(TestEvent.EVENT_NAME, testEvent.getMapForTestingPurposes())
    }

    @Test
    fun testSendAgain() {
        val testEvent = TestEvent().also { it.numberOfClicks = 10 }
        val analytics = spy(Analytics())

        val mockedAnalyticsService = mock<AnalyticsService>()
        analytics.addService(mockedAnalyticsService)

        analytics.send(testEvent)
        analytics.send(testEvent)

        verify(mockedAnalyticsService, times(2)).send(TestEvent.EVENT_NAME, testEvent.getMapForTestingPurposes())
    }

    @Test
    fun testRemoveServiceAndSend() {
        val testEvent = TestEvent().also { it.numberOfClicks = 10 }
        val analytics = spy(Analytics())

        val mockedAnalyticsService = mock<AnalyticsService>()
        analytics.addService(mockedAnalyticsService)
        analytics.removeService(mockedAnalyticsService)

        analytics.send(testEvent)

        verify(mockedAnalyticsService, never()).send(any(), any())
    }
}