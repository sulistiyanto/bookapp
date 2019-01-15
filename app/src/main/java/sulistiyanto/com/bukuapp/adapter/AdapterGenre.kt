package sulistiyanto.com.bukuapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_genre.view.*
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.data.model.GenreModel

class AdapterGenre(private var items: List<GenreModel>,
                   private val listener: (GenreModel) -> Unit):
    RecyclerView.Adapter<AdapterGenre.GenreHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GenreHolder {
        return GenreHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_genre, parent, false))

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {
        holder.bindData(items[position], listener)
    }

    class GenreHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val txtTitle = itemView.txt_title
        private val image = itemView.image

        fun bindData(genreModel: GenreModel, listener: (GenreModel) -> Unit) {

            txtTitle.text = genreModel.title
            itemView.setOnClickListener {
                listener(genreModel)
            }
        }

    }
}