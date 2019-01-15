package sulistiyanto.com.bukuapp.ui.book


import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterBook
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.BookModel
import sulistiyanto.com.bukuapp.di.subcomponent.FragmentComponent
import sulistiyanto.com.bukuapp.ui.base.BaseFragment
import sulistiyanto.com.bukuapp.ui.detailBook.DetailBookActivity
import sulistiyanto.com.bukuapp.utilities.ConnectingNetwork
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class BookFragment : BaseFragment(), BookView {

    private lateinit var gridLayoutManager: GridLayoutManager
    private var rvBook: RecyclerView? = null
    private var progressBar : ProgressBar? = null

    @Inject
    lateinit var presenter: BookPresenter
    @Inject
    lateinit var connectingNetwork: ConnectingNetwork

    override fun getFragmentLayout(): Int = R.layout.fragment_book

    override fun initInjection() {
        val fragmentComponent: FragmentComponent = (activity?.applicationContext as App)
            .appComponent
            .fragmentComponent()
            .build()

        fragmentComponent.inject(this)
    }

    override fun initLayout(rootView: View?) {
        presenter.attach(this)
        rvBook = rootView?.findViewById(R.id.rv_book)
        progressBar = rootView?.findViewById(R.id.progressBar)

        initRecyclerView()

        presenter.getData(connectingNetwork.isConnecting())
    }

    override fun displayBookList(adapter: AdapterBook) {
        rvBook?.adapter = adapter

    }

    override fun detailBook(book: BookModel) {
        val intent = Intent(context, DetailBookActivity::class.java)
        intent.putExtra("id", book.id)
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

    private fun initRecyclerView() {
        gridLayoutManager = GridLayoutManager(context,2)
        rvBook?.layoutManager = gridLayoutManager
        rvBook?.itemAnimator = DefaultItemAnimator()
        rvBook?.setHasFixedSize(true)
    }
}
