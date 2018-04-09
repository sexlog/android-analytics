package br.com.esapiens.analytics

/**
 * Created by esapiens on 06/04/18.
 */
class LogAnalyticsService(private val logFunction: (String) -> Unit = ::println) : AnalyticsService {
    override fun send(name: String, map: Map<String, Any>) {
        logFunction("ANALYTICS LOG")
        logFunction("Event: $name")
        logFunction(map.toString())
    }
}