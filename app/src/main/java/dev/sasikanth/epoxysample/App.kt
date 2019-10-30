package dev.sasikanth.epoxysample

import android.app.Application
import com.airbnb.epoxy.Carousel

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }
}