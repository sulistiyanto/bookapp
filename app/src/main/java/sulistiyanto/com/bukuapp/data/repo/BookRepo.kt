package sulistiyanto.com.bukuapp.data.repo

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import sulistiyanto.com.bukuapp.data.apiService.APIServiceBook
import sulistiyanto.com.bukuapp.data.model.*
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
        token: String, limit: String,
        response: (List<BookModel>?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.getBook(token, limit)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .subscribe(
                {
                    response(it?.result)
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

    fun getBookByGenre(
        token: String, id: String,
        response: (List<BookModel>?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.bookByGenre(token, id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .subscribe(
                {
                    response(it?.result)
                },
                { error(it) }
            )

    fun getDetailBook(
        token: String, id: String,
        response: (DetailBookModel?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.getBookDetail(token, id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .subscribe(
                {
                    response(it?.result)
                },
                { error(it) }
            )

    fun getDetailProfile(
        token: String, id: String,
        response: (DetailProfileModel?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.getWriterDetail(token, id)
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