package sulistiyanto.com.bukuapp.ui.genre

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.adapter.AdapterGenre
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.data.model.GenreModel
import sulistiyanto.com.bukuapp.di.subcomponent.FragmentComponent
import sulistiyanto.com.bukuapp.ui.base.BaseFragment
import sulistiyanto.com.bukuapp.ui.bookByGenre.BookGenreActivity
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class GenreFragment : BaseFragment(), GenreView {

    private var rvGenre: RecyclerView? = null

    @Inject
    lateinit var presenter: GenrePresenter

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
        rvGenre?.layoutManager = LinearLayoutManager(context)
        rvGenre?.itemAnimator = DefaultItemAnimator()
        rvGenre?.setHasFixedSize(true)

        presenter.getData()
    }

    override fun displayGenreList(adapter: AdapterGenre) {
        rvGenre?.adapter = adapter
    }

    override fun displayBookByGenre(genre: GenreModel) {
        val intent = Intent(context, BookGenreActivity::class.java)
        intent.putExtra("id", "${genre.id}")
        startActivity(intent)
    }
}
