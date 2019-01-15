package sulistiyanto.com.bukuapp.ui.genre

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_genre.*

import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterGenre
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.GenreModel
import sulistiyanto.com.bukuapp.di.subcomponent.FragmentComponent
import sulistiyanto.com.bukuapp.ui.base.BaseFragment
import sulistiyanto.com.bukuapp.ui.bookByGenre.BookGenreActivity
import sulistiyanto.com.bukuapp.utilities.ConnectingNetwork
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class GenreFragment : BaseFragment(), GenreView {

    private var rvGenre: RecyclerView? = null
    private var progressBar : ProgressBar? = null

    @Inject
    lateinit var presenter: GenrePresenter
    @Inject
    lateinit var connectingNetwork: ConnectingNetwork

    override fun getFragmentLayout(): Int = R.layout.fragment_genre

    override fun initInjection() {
        val fragmentComponent: FragmentComponent = (activity?.applicationContext as App)
            .appComponent
            .fragmentComponent()
            .build()

        fragmentComponent.inject(this)
    }

    override fun initLayout(rootView: View?) {
        presenter.attach(this)
        rvGenre = rootView?.findViewById(R.id.rv_genre)
        progressBar = rootView?.findViewById(R.id.progressBar)
        initRecyclerView()

        presenter.getData(connectingNetwork.isConnecting())
    }

    private fun initRecyclerView() {
        rvGenre?.layoutManager = LinearLayoutManager(context)
        rvGenre?.itemAnimator = DefaultItemAnimator()
        rvGenre?.setHasFixedSize(true)
    }

    override fun displayGenreList(adapter: AdapterGenre) {
        rvGenre?.adapter = adapter
    }

    override fun displayBookByGenre(genre: GenreModel) {
        val intent = Intent(context, BookGenreActivity::class.java)
        intent.putExtra("id", genre.id)
        intent.putExtra("title", genre.title)
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
