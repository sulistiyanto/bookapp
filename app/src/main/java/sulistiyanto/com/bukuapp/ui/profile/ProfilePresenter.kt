package sulistiyanto.com.bukuapp.ui.profile

import sulistiyanto.com.bukuapp.adapter.AdapterProfile
import sulistiyanto.com.bukuapp.data.model.ProfileModel
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfilePresenter @Inject constructor(): BasePresenter<ProfileView>() {

    fun getData() {
        val list = ArrayList<ProfileModel>()
        for (i in 1..20) {
            list.add(ProfileModel(i, "Sulistiyanto", "Jogja"))
        }
        val adapter = AdapterProfile(list) { profile ->
            view?.detailProfile(profile)
        }
        view?.displayProfileList(adapter)
    }
}