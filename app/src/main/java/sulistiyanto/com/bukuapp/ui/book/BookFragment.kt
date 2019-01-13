package sulistiyanto.com.bukuapp.ui.book


import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterBook
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.BookModel
import sulistiyanto.com.bukuapp.di.subcomponent.FragmentComponent
import sulistiyanto.com.bukuapp.ui.base.BaseFragment
import sulistiyanto.com.bukuapp.ui.detailBook.DetailBookActivity
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class BookFragment : BaseFragment(), BookView {

    private lateinit var gridLayoutManager: GridLayoutManager
    private var rvBook: RecyclerView? = null

    @Inject
    lateinit var presenter: BookPresenter


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

        gridLayoutManager = GridLayoutManager(context,2)
        rvBook?.layoutManager = gridLayoutManager
        rvBook?.itemAnimator = DefaultItemAnimator()
        rvBook?.setHasFixedSize(true)

        presenter.getData()
    }

    override fun displayBookList(adapter: AdapterBook) {
        rvBook?.adapter = adapter

    }

    override fun detailBook(book: BookModel) {
        val intent = Intent(context, DetailBookActivity::class.java)
        intent.putExtra("book", book)
        startActivity(intent)
    }

}
