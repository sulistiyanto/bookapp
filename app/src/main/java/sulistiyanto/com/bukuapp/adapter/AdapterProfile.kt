package sulistiyanto.com.bukuapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.data.model.ProfileModel

class AdapterProfile(private var items: List<ProfileModel>,
                     val listener: (ProfileModel) -> Unit):
    RecyclerView.Adapter<AdapterProfile.ProfileHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProfileHolder {
        return ProfileHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_profile, parent, false))

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        holder.bindData(items[position], listener)
    }

    class ProfileHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindData(profileModel: ProfileModel, listener: (ProfileModel) -> Unit) {


            itemView.setOnClickListener {
                listener(profileModel)
            }
        }

    }
}