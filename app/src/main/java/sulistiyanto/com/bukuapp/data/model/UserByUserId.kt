package sulistiyanto.com.bukuapp.data.model

import com.google.gson.annotations.SerializedName

data class UserByUserId(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("photo_url") val photoUrl: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("username") val username: String?
)