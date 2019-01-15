package sulistiyanto.com.bukuapp.ui.detailProfile

import sulistiyanto.com.bukuapp.data.repo.BookRepo
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import sulistiyanto.com.bukuapp.utilities.token
import javax.inject.Inject

class ProfilePresenter @Inject constructor(private val repo: BookRepo) :
    BasePresenter<ProfileView>() {

    fun getDetailProfile(connecting: Boolean, id: Int) {
        if (connecting) {
            view?.viewLoadingProgress()
            disposables.add(repo.getDetailProfile(
                token, id.toString(),
                response = { detailProfile ->
                    view?.hideLoadingProgress()
                    view?.displayDetail(detailProfile)
                },
                error = {
                    view?.hideLoadingProgress()
                    view?.displayError("Gagal mendapatkan data dari server")}))
        } else {
            view?.displayError("Periksa koneksi internet Anda")
        }
    }
}