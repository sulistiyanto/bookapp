package sulistiyanto.com.bukuapp.application

import android.app.Application
import sulistiyanto.com.bukuapp.di.AppComponent
import sulistiyanto.com.bukuapp.di.AppModule
import sulistiyanto.com.bukuapp.di.DaggerAppComponent
import sulistiyanto.com.bukuapp.di.module.ApiServiceModule
import sulistiyanto.com.bukuapp.di.module.NetworkModule


open class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .apiServiceModule(ApiServiceModule())
            .appModule(AppModule(applicationContext))
            .build()
    }
}