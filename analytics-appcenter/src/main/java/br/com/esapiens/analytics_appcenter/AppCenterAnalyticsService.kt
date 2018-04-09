package br.com.esapiens.analytics_appcenter

import android.app.Application
import br.com.esapiens.analytics.AnalyticsService
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.AppCenterService
import com.microsoft.appcenter.analytics.Analytics

/**
 * Created by esapiens on 09/04/18.
 */
class AppCenterAnalyticsService(application: Application, appSecret: String, vararg otherServices: Class<AppCenterService>) : AnalyticsService {
    init {
        AppCenter.start(application, appSecret, Analytics::class.java, *otherServices)
    }

    override fun send(name: String, map: Map<String, Any>) {
        Analytics.trackEvent(name, map.mapValues { it.value.toString() })
    }
}