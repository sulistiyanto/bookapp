package sulistiyanto.com.bukuapp.ui.bookByGenre

import android.content.Intent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_book_genre.*
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterBook
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.BookModel
import sulistiyanto.com.bukuapp.di.subcomponent.ActivityComponent
import sulistiyanto.com.bukuapp.ui.base.BaseActivity
import sulistiyanto.com.bukuapp.ui.detailBook.DetailBookActivity
import sulistiyanto.com.bukuapp.utilities.ConnectingNetwork
import javax.inject.Inject

class BookGenreActivity : BaseActivity(), BookGenreView {

    private lateinit var gridLayoutManager: GridLayoutManager

    @Inject
    lateinit var presenter: BookGenrePresenter
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
        setContentView(R.layout.activity_book_genre)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        gridLayoutManager = GridLayoutManager(this,2)
        rvBook?.layoutManager = gridLayoutManager
        rvBook?.itemAnimator = DefaultItemAnimator()
        rvBook?.setHasFixedSize(true)

        val id = intent.getIntExtra("id", 0)
        val title = intent.getStringExtra("title")
        supportActionBar?.title = "Buku $title"

        presenter.getBookByGenre(connectingNetwork.isConnecting(), id)
    }

    override fun displayBookList(adapter: AdapterBook) {
        rvBook.adapter = adapter
    }

    override fun detailBook(book: BookModel) {
        val intent = Intent(this, DetailBookActivity::class.java)
        intent.putExtra("id", book.id)
        startActivity(intent)
    }

    override fun viewLoadingProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoadingProgress() {
        progressBar.visibility = View.GONE
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
