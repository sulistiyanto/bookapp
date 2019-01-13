package sulistiyanto.com.bukuapp.ui.genre

import sulistiyanto.com.bukuapp.adapter.AdapterGenre
import sulistiyanto.com.bukuapp.data.model.GenreModel
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import javax.inject.Inject

class GenrePresenter @Inject constructor(): BasePresenter<GenreView>() {

    fun getData() {
        val list = ArrayList<GenreModel>()
        for (i in 1..20) {
            list.add(GenreModel(i, "Teknologi"))
        }
        val adapter = AdapterGenre(list) { genre ->
            view?.displayBookByGenre(genre)
        }
        view?.displayGenreList(adapter)
    }
}