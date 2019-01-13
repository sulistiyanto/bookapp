package sulistiyanto.com.bukuapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProfileModel(val id: Int, val name: String, val address: String) : Parcelable