package sulistiyanto.com.bukuapp.ui.genre

import sulistiyanto.com.bukuapp.adapter.AdapterGenre
import sulistiyanto.com.bukuapp.data.repo.BookRepo
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import sulistiyanto.com.bukuapp.utilities.token
import javax.inject.Inject

class GenrePresenter @Inject constructor(private val repo: BookRepo) : BasePresenter<GenreView>() {

    fun getData(connecting: Boolean) {
        if (connecting) {
            view?.viewLoadingProgress()
            disposables.add(
                repo.getGenre(token,
                    response = { listGenre ->
                        view?.hideLoadingProgress()
                        val adapter = listGenre?.let {
                            AdapterGenre(it) { genre ->
                                view?.displayBookByGenre(genre)
                            }
                        }
                        adapter?.let { view?.displayGenreList(it) }
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