package sulistiyanto.com.bukuapp.ui.book

import sulistiyanto.com.bukuapp.adapter.AdapterBook
import sulistiyanto.com.bukuapp.data.model.BookModel
import sulistiyanto.com.bukuapp.ui.base.BaseView

interface BookView: BaseView {

    fun displayBookList(adapter: AdapterBook)
    fun detailBook(book: BookModel)
}