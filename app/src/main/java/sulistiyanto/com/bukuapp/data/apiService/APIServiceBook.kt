package sulistiyanto.com.bukuapp.data.apiService

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import sulistiyanto.com.bukuapp.data.model.*

interface APIServiceBook {

    @GET("cabaca/_table/genre")
    fun getGenre(
        @Header("x-dreamfactory-api-key") token: String
    ): Observable<GenreResponseModel?>

    @GET("book/category")
    fun bookByGenre(
        @Header("x-dreamfactory-api-key") token: String,
        @Query("id") name: String
    ): Observable<BookResponseModel?>

    @GET("book/uptodate")
    fun getBook(
        @Header("x-dreamfactory-api-key") token: String,
        @Query("limit") limit: String
    ): Observable<BookResponseModel?>

    @GET("book/detail/{book_id}")
    fun getBookDetail(
        @Header("x-dreamfactory-api-key") token: String,
        @Path("book_id") bookId: String
    ): Observable<DetailBookResponseModel?>

    @GET("writer/popular")
    fun getWriter(
        @Header("x-dreamfactory-api-key") token: String,
        @Query("limit") limit: String
    ): Observable<ProfileResponseModel?>

    @GET("writer/detail/{user_id}")
    fun getWriterDetail(
        @Header("x-dreamfactory-api-key") token: String,
        @Path("user_id") userId: String
    ): Observable<DetailProfileResponseModel?>
}