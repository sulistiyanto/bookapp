package sulistiyanto.com.bukuapp.ui.book

import sulistiyanto.com.bukuapp.adapter.AdapterBook
import sulistiyanto.com.bukuapp.data.model.BookModel
import sulistiyanto.com.bukuapp.ui.base.BaseView

interface BookView: BaseView {

    fun viewLoadingProgress()
    fun hideLoadingProgress()
    fun displayBookList(adapter: AdapterBook)
    fun detailBook(book: BookModel)
}