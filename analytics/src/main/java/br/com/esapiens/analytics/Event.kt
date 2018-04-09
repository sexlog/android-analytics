package br.com.esapiens.analytics

/**
 * Created by esapiens on 06/04/18.
 */
abstract class Event {
    abstract val name: String
    val valuesMap = mutableMapOf<String, Any>()
}