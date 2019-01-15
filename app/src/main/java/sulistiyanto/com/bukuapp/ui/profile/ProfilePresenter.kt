package sulistiyanto.com.bukuapp.ui.profile

import android.content.Context
import sulistiyanto.com.bukuapp.adapter.AdapterProfile
import sulistiyanto.com.bukuapp.data.repo.BookRepo
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import sulistiyanto.com.bukuapp.utilities.token
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfilePresenter @Inject constructor(private val repo: BookRepo, private val context: Context) :
    BasePresenter<ProfileView>() {

    fun getData(connecting: Boolean) {
        if (connecting) {
            view?.viewLoadingProgress()
            disposables.add(
                repo.getProfile(
                    token, "10",
                    response = { listProfile ->
                        view?.hideLoadingProgress()
                        val adapter = listProfile?.let {
                            AdapterProfile(context, it) { profile ->
                                view?.detailProfile(profile)
                            }
                        }
                        adapter?.let { view?.displayProfileList(it) }
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