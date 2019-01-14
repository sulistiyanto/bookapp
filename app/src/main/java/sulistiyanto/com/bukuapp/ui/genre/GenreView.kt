package sulistiyanto.com.bukuapp.ui.genre

import sulistiyanto.com.bukuapp.adapter.AdapterGenre
import sulistiyanto.com.bukuapp.data.model.GenreModel
import sulistiyanto.com.bukuapp.ui.base.BaseView

interface GenreView: BaseView {

    fun viewLoadingProgress()
    fun hideLoadingProgress()
    fun displayGenreList(adapter: AdapterGenre)
    fun displayBookByGenre(genre: GenreModel)
}