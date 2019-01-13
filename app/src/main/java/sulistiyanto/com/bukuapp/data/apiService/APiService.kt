package sulistiyanto.com.bukuapp.data.apiService

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import sulistiyanto.com.bukuapp.data.model.GenreModel

interface APiService {

    @GET("cabaca/_table/genre")
    fun getGenre(
        @Header("x-dreamfactory-api-key") token: String
    ): Observable<List<GenreModel>?>


    @GET("book/category")
    fun bookByGenre(
        @Header("x-dreamfactory-api-key") token: String,
        @Query("id") name: String
    ): Observable<List<GenreModel>?>
}