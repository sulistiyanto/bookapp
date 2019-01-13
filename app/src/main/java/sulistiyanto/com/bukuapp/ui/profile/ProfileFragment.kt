package sulistiyanto.com.bukuapp.ui.profile

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterProfile
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.ProfileModel
import sulistiyanto.com.bukuapp.di.subcomponent.FragmentComponent
import sulistiyanto.com.bukuapp.ui.base.BaseFragment
import sulistiyanto.com.bukuapp.ui.detailProfile.ProfileActivity
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : BaseFragment(), ProfileView {

    private var rvProfile: RecyclerView? = null

    @Inject
    lateinit var presenter: ProfilePresenter

    override fun getFragmentLayout(): Int = R.layout.fragment_profile

    override fun initInjection() {
        val fragmentComponent: FragmentComponent = (activity?.applicationContext as App)
            .appComponent
            .fragmentComponent()
            .build()

        fragmentComponent.inject(this)
    }

    override fun initLayout(rootView: View?) {
        presenter.attach(this)
        rvProfile = rootView?.findViewById(R.id.rv_profile)
        rvProfile?.layoutManager = LinearLayoutManager(context)
        rvProfile?.itemAnimator = DefaultItemAnimator()
        rvProfile?.setHasFixedSize(true)

        presenter.getData()
    }

    override fun displayProfileList(adapter: AdapterProfile) {
        rvProfile?.adapter = adapter
    }

    override fun detailProfile(profile: ProfileModel) {
        val intent = Intent(context, ProfileActivity::class.java)
        intent.putExtra("profile", profile)
        startActivity(intent)
    }
}
