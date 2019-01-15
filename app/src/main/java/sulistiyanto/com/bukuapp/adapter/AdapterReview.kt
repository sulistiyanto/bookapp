package sulistiyanto.com.bukuapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_review.view.*
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.data.model.ReviewModel
import sulistiyanto.com.bukuapp.utilities.GlideApp
import sulistiyanto.com.bukuapp.utilities.api
import sulistiyanto.com.bukuapp.utilities.baseURLImage

class AdapterReview(
    private val context: Context, private var items: List<ReviewModel>
    ) :
    RecyclerView.Adapter<AdapterReview.ReviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ReviewHolder {
        return ReviewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_review, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        holder.bindData(items[position], context)
    }

    class ReviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtUsername = itemView.txt_username
        private val txtReview = itemView.txt_review
        private val imgProfile = itemView.image
        private val ratingBar = itemView.ratingBar

        @SuppressLint("SetTextI18n")
        fun bindData(
            reviewModel: ReviewModel,
            context: Context
        ) {

            txtUsername.text = reviewModel.userByUserId?.username
            txtReview.text = reviewModel.review
            ratingBar.rating = reviewModel.rating?.toFloat()!!

            GlideApp.with(context)
                .load("$baseURLImage${reviewModel.userByUserId?.photoUrl}&$api")
                .placeholder(R.mipmap.ic_launcher)
                .into(imgProfile)

        }

    }
}