package sulistiyanto.com.bukuapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_profile.view.*
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.data.model.ProfileModel
import sulistiyanto.com.bukuapp.utilities.GlideApp
import sulistiyanto.com.bukuapp.utilities.api
import sulistiyanto.com.bukuapp.utilities.baseURLImage

class AdapterProfile(
    private val context: Context, private var items: List<ProfileModel>,
    private val listener: (ProfileModel) -> Unit
) :
    RecyclerView.Adapter<AdapterProfile.ProfileHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProfileHolder {
        return ProfileHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_profile, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        holder.bindData(items[position], listener, context)
    }

    class ProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtName = itemView.txt_name
        private val txtFollower = itemView.txt_follower
        private val imgProfile = itemView.image

        @SuppressLint("SetTextI18n")
        fun bindData(
            profileModel: ProfileModel,
            listener: (ProfileModel) -> Unit,
            context: Context
        ) {

            txtName.text = profileModel.name
            txtFollower.text = "Pengikut: ${profileModel.countFollower}"

            GlideApp.with(context)
                .load("$baseURLImage${profileModel.photoUrl}&$api")
                .placeholder(R.mipmap.ic_launcher)
                .into(imgProfile)

            itemView.setOnClickListener {
                listener(profileModel)
            }
        }

    }
}