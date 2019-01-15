package sulistiyanto.com.bukuapp.ui.detailBook

import sulistiyanto.com.bukuapp.data.model.DetailBookModel
import sulistiyanto.com.bukuapp.ui.base.BaseView

interface DetailBookView: BaseView {

    fun viewLoadingProgress()
    fun hideLoadingProgress()
    fun displayDetail(detailBook: DetailBookModel?)
}