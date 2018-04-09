package br.com.esapiens.analytics

/**
 * Created by esapiens on 06/04/18.
 */
class Analytics {
    private val services = mutableSetOf<AnalyticsService>()

    fun addService(analyticsService: AnalyticsService) {
        val incomingAnalyticsServiceType = analyticsService.javaClass
        if (services.find { it.javaClass.isAssignableFrom(analyticsService.javaClass) } != null) {
            throw UnsupportedOperationException("There's already an AnalyticsService of type ${incomingAnalyticsServiceType.simpleName}")
        }

        services.add(analyticsService)
    }

    fun removeService(analyticsService: AnalyticsService) {
        services.remove(analyticsService)
    }

    fun send(event: Event) {
        synchronized(this) {
            val valuesMap = event.valuesMap
            services.forEach {
                it.send(event.name, valuesMap)
            }
        }
    }
}