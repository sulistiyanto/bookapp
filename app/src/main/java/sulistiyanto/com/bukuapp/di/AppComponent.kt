package sulistiyanto.com.bukuapp.di

import dagger.Component
import sulistiyanto.com.bukuapp.di.module.ApiServiceModule
import sulistiyanto.com.bukuapp.di.module.NetworkModule
import sulistiyanto.com.bukuapp.di.subcomponent.ActivityComponent
import sulistiyanto.com.bukuapp.di.subcomponent.FragmentComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    ApiServiceModule::class
])
interface AppComponent {

    fun activityComponent(): ActivityComponent.Builder
    fun fragmentComponent(): FragmentComponent.Builder
}