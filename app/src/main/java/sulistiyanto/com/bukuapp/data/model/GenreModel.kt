package sulistiyanto.com.bukuapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class GenreResponseModel(@SerializedName("resource") val resource: List<GenreModel>?)

@Parcelize
data class GenreModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("icon_url") val iconUrl: String?
) : Parcelable