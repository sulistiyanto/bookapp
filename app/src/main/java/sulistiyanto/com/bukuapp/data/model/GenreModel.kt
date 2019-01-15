package sulistiyanto.com.bukuapp.data.model

import com.google.gson.annotations.SerializedName

data class GenreResponseModel(@SerializedName("resource") val resource: List<GenreModel>?)

data class GenreModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("icon_url") val iconUrl: String?
)