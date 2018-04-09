package br.com.esapiens.analytics

/**
 * Created by esapiens on 09/04/18.
 */
class TestEvent(): Event() {
    companion object {
        @JvmStatic
        val EVENT_NAME = "testEvent"
    }
    override val name = EVENT_NAME
    var numberOfClicks: Int by valuesMap

    fun getMapForTestingPurposes(): Map<String, Any> {
        return mapOf("numberOfClicks" to numberOfClicks)
    }
}