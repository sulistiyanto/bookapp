package sulistiyanto.com.bukuapp.ui.detailProfile

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterBook
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.DetailProfileModel
import sulistiyanto.com.bukuapp.di.subcomponent.ActivityComponent
import sulistiyanto.com.bukuapp.ui.base.BaseActivity
import sulistiyanto.com.bukuapp.ui.detailBook.DetailBookActivity
import sulistiyanto.com.bukuapp.utilities.ConnectingNetwork
import sulistiyanto.com.bukuapp.utilities.GlideApp
import sulistiyanto.com.bukuapp.utilities.api
import sulistiyanto.com.bukuapp.utilities.baseURLImage
import javax.inject.Inject

class ProfileActivity : BaseActivity(), ProfileView {

    @Inject
    lateinit var presenter: ProfilePresenter
    @Inject
    lateinit var connectingNetwork: ConnectingNetwork

    override fun initInjection() {
        val activityComponent: ActivityComponent = (applicationContext as App)
            .appComponent
            .activityComponent()
            .build()
        activityComponent.inject(this)
    }

    override fun initLayout() {
        presenter.attach(this)
        setContentView(R.layout.activity_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Profil"
        initRecyclerView()

        val id = intent.getIntExtra("id", 0)

        presenter.getDetailProfile(connectingNetwork.isConnecting(), id)
    }

    private fun initRecyclerView() {
        val gridLayoutManager = GridLayoutManager(this,2)
        rvBook.layoutManager = gridLayoutManager
        rvBook.itemAnimator = DefaultItemAnimator()
        rvBook.setHasFixedSize(true)
        rvBook.isNestedScrollingEnabled = false
    }

    override fun viewLoadingProgress() {
        progressBar.visibility = View.VISIBLE
        constraintLayout.visibility = View.GONE
    }

    override fun hideLoadingProgress() {
        progressBar.visibility = View.GONE
        constraintLayout.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    override fun displayDetail(detailProfile: DetailProfileModel?) {

        GlideApp.with(this)
            .load("$baseURLImage${detailProfile?.photoUrl}&$api")
            .placeholder(R.mipmap.ic_launcher)
            .into(image)

        txtName.text = ": ${detailProfile?.name}"
        txtEmail.text = ": ${detailProfile?.email}"
        txtPhone.text = ": ${detailProfile?.phone}"
        txtGender.text = ": ${detailProfile?.gender}"
        txtDesc.text = detailProfile?.description

        val adapter = detailProfile?.creation?.let {
            AdapterBook(this, it) { book->
                val intent = Intent(this, DetailBookActivity::class.java)
                intent.putExtra("id", book.id)
                startActivity(intent)
            }
        }
        rvBook?.adapter = adapter
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
