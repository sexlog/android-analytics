package br.com.esapiens.flurry

import android.app.Application
import br.com.esapiens.analytics.AnalyticsService
import com.flurry.android.FlurryAgent

/**
 * Created by mcastro on 31/05/18.
 */
class FlurryAnalyticsService(application: Application, flurryApiKey: String) : AnalyticsService {

    init {
        FlurryAgent.Builder().build(application, flurryApiKey)
    }

    override fun send(name: String, map: Map<String, Any>) {
        FlurryAgent.logEvent(name, map.mapValues { it.value.toString() })
    }
}