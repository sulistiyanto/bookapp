package sulistiyanto.com.bukuapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_book.view.*
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.data.model.BookModel
import sulistiyanto.com.bukuapp.utilities.GlideApp
import sulistiyanto.com.bukuapp.utilities.api
import sulistiyanto.com.bukuapp.utilities.baseURLImage

class AdapterBook(
    private val context: Context, private var items: List<BookModel>,
    private val listener: (BookModel) -> Unit
) :
    RecyclerView.Adapter<AdapterBook.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BookHolder {
        return BookHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_book, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bindData(items[position], listener, context)
    }

    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageCover = itemView.image
        private val txtTitle = itemView.txt_title
        private val ratingBar = itemView.ratingBar

        fun bindData(
            bookModel: BookModel,
            listener: (BookModel) -> Unit,
            context: Context
        ) {

            GlideApp.with(context)
                .load("$baseURLImage${bookModel.coverUrl}&$api")
                .placeholder(R.mipmap.ic_launcher)
                .into(imageCover)

            txtTitle.text = bookModel.title
            ratingBar.rating = bookModel.rateSum!!

            itemView.setOnClickListener {
                listener(bookModel)
            }
        }

    }
}