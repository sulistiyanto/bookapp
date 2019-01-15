package sulistiyanto.com.bukuapp.ui.detailProfile

import sulistiyanto.com.bukuapp.data.model.DetailProfileModel
import sulistiyanto.com.bukuapp.ui.base.BaseView

interface ProfileView: BaseView {
    fun viewLoadingProgress()
    fun hideLoadingProgress()
    fun displayDetail(detailProfile: DetailProfileModel?)
}