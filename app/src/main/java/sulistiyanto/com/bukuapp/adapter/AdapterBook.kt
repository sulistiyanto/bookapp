package sulistiyanto.com.bukuapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.data.model.BookModel

class AdapterBook (private var items: List<BookModel>,
                   private val listener: (BookModel) -> Unit):
    RecyclerView.Adapter<AdapterBook.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BookHolder {
        return BookHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_book, parent, false))

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bindData(items[position], listener)
    }

    class BookHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindData(profileModel: BookModel, listener: (BookModel) -> Unit) {


            itemView.setOnClickListener {
                listener(profileModel)
            }
        }

    }
}