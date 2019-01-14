package sulistiyanto.com.bukuapp.data.repo

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import sulistiyanto.com.bukuapp.data.apiService.APIServiceBook
import sulistiyanto.com.bukuapp.data.model.GenreModel
import sulistiyanto.com.bukuapp.data.model.ProfileModel
import javax.inject.Inject

class BookRepo @Inject constructor(private val apiService: APIServiceBook) {

    fun getGenre(
        token: String,
        response: (List<GenreModel>?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.getGenre(token)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .subscribe(
                {
                    response(it?.resource)
                },
                { error(it) }
            )

    fun getBook(
        token: String,
        response: (List<GenreModel>?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.getGenre(token)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .subscribe(
                {
                    response(it?.resource)
                },
                { error(it) }
            )

    fun getProfile(
        token: String, limit: String,
        response: (List<ProfileModel>?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.getWriter(token, limit)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .subscribe(
                {
                    response(it?.result)
                },
                { error(it) }
            )
}