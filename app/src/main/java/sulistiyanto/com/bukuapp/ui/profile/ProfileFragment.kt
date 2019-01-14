package sulistiyanto.com.bukuapp.ui.profile

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterProfile
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.ProfileModel
import sulistiyanto.com.bukuapp.di.subcomponent.FragmentComponent
import sulistiyanto.com.bukuapp.ui.base.BaseFragment
import sulistiyanto.com.bukuapp.ui.detailProfile.ProfileActivity
import sulistiyanto.com.bukuapp.utilities.ConnectingNetwork
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : BaseFragment(), ProfileView {

    private var rvProfile: RecyclerView? = null
    private var progressBar : ProgressBar? = null

    @Inject
    lateinit var presenter: ProfilePresenter
    @Inject
    lateinit var connectingNetwork: ConnectingNetwork

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
        progressBar = rootView?.findViewById(R.id.progressBar)

        rvProfile?.layoutManager = LinearLayoutManager(context)
        rvProfile?.itemAnimator = DefaultItemAnimator()
        rvProfile?.setHasFixedSize(true)

        presenter.getData(connectingNetwork.isConnecting())
    }

    override fun displayProfileList(adapter: AdapterProfile) {
        rvProfile?.adapter = adapter
    }

    override fun detailProfile(profile: ProfileModel) {
        val intent = Intent(context, ProfileActivity::class.java)
        intent.putExtra("profile", profile)
        startActivity(intent)
    }

    override fun viewLoadingProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun hideLoadingProgress() {
        progressBar?.visibility = View.GONE
    }

    override fun displayError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
