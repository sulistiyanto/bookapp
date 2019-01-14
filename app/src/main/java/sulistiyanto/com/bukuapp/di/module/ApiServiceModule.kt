package sulistiyanto.com.bukuapp.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sulistiyanto.com.bukuapp.data.apiService.APIServiceBook
import javax.inject.Singleton

@Module
class ApiServiceModule {

    @Provides
    @Singleton
    fun providesApiServiceBook(retrofit: Retrofit): APIServiceBook =
        retrofit.create(APIServiceBook::class.java)
}