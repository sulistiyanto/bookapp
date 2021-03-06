package sulistiyanto.com.bukuapp.ui.book

import android.content.Context
import sulistiyanto.com.bukuapp.adapter.AdapterBook
import sulistiyanto.com.bukuapp.data.repo.BookRepo
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import sulistiyanto.com.bukuapp.utilities.token
import javax.inject.Inject

class BookPresenter @Inject constructor(private val repo: BookRepo, private val context: Context) :
    BasePresenter<BookView>() {

    fun getData(connecting: Boolean) {
        if (connecting) {
            view?.viewLoadingProgress()
            disposables.add(
                repo.getBook(
                    token, "10",
                    response = { listProfile ->
                        view?.hideLoadingProgress()
                        val adapter = listProfile?.let {
                            AdapterBook(context, it) { book ->
                                view?.detailBook(book)
                            }
                        }
                        adapter?.let { view?.displayBookList(it) }
                    },
                    error = {
                        view?.hideLoadingProgress()
                        view?.displayError("Gagal mendapatkan data dari server")
                    })
            )
        } else {
            view?.displayError("Periksa koneksi internet Anda")
        }
    }
}