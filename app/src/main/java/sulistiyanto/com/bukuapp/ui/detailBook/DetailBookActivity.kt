package sulistiyanto.com.bukuapp.ui.detailBook

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail_book.*
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterReview
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.DetailBookModel
import sulistiyanto.com.bukuapp.di.subcomponent.ActivityComponent
import sulistiyanto.com.bukuapp.ui.base.BaseActivity
import sulistiyanto.com.bukuapp.utilities.ConnectingNetwork
import sulistiyanto.com.bukuapp.utilities.GlideApp
import sulistiyanto.com.bukuapp.utilities.api
import sulistiyanto.com.bukuapp.utilities.baseURLImage
import javax.inject.Inject

class DetailBookActivity : BaseActivity(), DetailBookView {

    @Inject
    lateinit var presenter: DetailBookPresenter
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
        setContentView(R.layout.activity_detail_book)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Buku"
        initRecyclerView()

        val id = intent.getIntExtra("id", 0)

        presenter.getDetailBook(connectingNetwork.isConnecting(), id)
    }

    private fun initRecyclerView() {
        rvReview.layoutManager = LinearLayoutManager(this)
        rvReview.itemAnimator = DefaultItemAnimator()
        rvReview.setHasFixedSize(true)
        rvReview.isNestedScrollingEnabled = false
    }

    override fun displayDetail(detailBook: DetailBookModel?) {

        ratingBar.rating = detailBook?.decimalRate!!
        GlideApp.with(this)
            .load("$baseURLImage${detailBook.coverURl}&$api")
            .placeholder(R.mipmap.ic_launcher)
            .into(image)

        txtTitle.text = detailBook.title
        txtDesc.text = detailBook.desc
        txtWriter.text = ": ${detailBook.writerByWriterId?.userByUserId?.name}"

        val adapter = detailBook.reviews?.let { AdapterReview(this, it) }
        rvReview.adapter = adapter
    }

    override fun viewLoadingProgress() {
        progressBar.visibility = View.VISIBLE
        constraintLayout.visibility = View.GONE
    }

    override fun hideLoadingProgress() {
        progressBar.visibility = View.GONE
        constraintLayout.visibility = View.VISIBLE
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
