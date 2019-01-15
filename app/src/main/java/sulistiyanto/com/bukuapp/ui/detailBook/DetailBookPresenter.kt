package sulistiyanto.com.bukuapp.ui.detailBook

import sulistiyanto.com.bukuapp.data.repo.BookRepo
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import sulistiyanto.com.bukuapp.utilities.token
import javax.inject.Inject

class DetailBookPresenter @Inject constructor(private val repo: BookRepo) :
    BasePresenter<DetailBookView>() {

    fun getDetailBook(connecting: Boolean, id: Int) {
        if (connecting) {
            view?.viewLoadingProgress()
            disposables.add(repo.getDetailBook(token, id.toString(),
                response = { detailBook ->
                    view?.hideLoadingProgress()
                    view?.displayDetail(detailBook)
                },
                error = {
                    view?.hideLoadingProgress()
                    view?.displayError("Gagal mendapatkan data dari server")}))
        } else {
            view?.displayError("Periksa koneksi internet Anda")
        }
    }
}