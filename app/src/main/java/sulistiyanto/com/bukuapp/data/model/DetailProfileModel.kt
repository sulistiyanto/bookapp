package sulistiyanto.com.bukuapp.data.model

import com.google.gson.annotations.SerializedName

data class DetailProfileResponseModel(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("result") val result: DetailProfileModel?
)

data class DetailProfileModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("photo_url") val photoUrl: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("deskripsi") val description: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("karya") val creation: List<BookModel>?
)