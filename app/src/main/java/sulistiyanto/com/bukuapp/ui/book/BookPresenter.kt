package sulistiyanto.com.bukuapp.ui.book

import sulistiyanto.com.bukuapp.adapter.AdapterBook
import sulistiyanto.com.bukuapp.data.model.BookModel
import sulistiyanto.com.bukuapp.ui.base.BasePresenter
import javax.inject.Inject

class BookPresenter @Inject constructor(): BasePresenter<BookView>() {
    fun getData() {
//        val list = ArrayList<BookModel>()
//        for (i in 1..20) {
//            list.add(BookModel(i, "", ""))
//        }
//        val adapter = AdapterBook(list) { book ->
//            view?.detailBook(book)
//        }
//        view?.displayBookList(adapter)
    }
}