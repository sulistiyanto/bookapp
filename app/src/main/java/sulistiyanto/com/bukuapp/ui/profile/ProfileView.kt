package sulistiyanto.com.bukuapp.ui.profile

import sulistiyanto.com.bukuapp.adapter.AdapterProfile
import sulistiyanto.com.bukuapp.data.model.ProfileModel
import sulistiyanto.com.bukuapp.ui.base.BaseView

interface ProfileView: BaseView {

    fun displayProfileList(adapter: AdapterProfile)
    fun detailProfile(profile: ProfileModel)
}