package sulistiyanto.com.bukuapp.ui.detailProfile

import sulistiyanto.com.bukuapp.data.repo.BookRepo
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import javax.inject.Inject

class ProfilePresenter @Inject constructor(private val repo: BookRepo) :
    BasePresenter<Profileview>() {

    fun getDetailProfile() {

    }
}