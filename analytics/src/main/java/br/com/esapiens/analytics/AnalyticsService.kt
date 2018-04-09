package br.com.esapiens.analytics

/**
 * Created by esapiens on 06/04/18.
 */
interface AnalyticsService {
    fun send(name: String, map: Map<String, Any>)
}