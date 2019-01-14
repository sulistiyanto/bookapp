package sulistiyanto.com.bukuapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ProfileResponseModel(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("result") val result: List<ProfileModel>?
)

@Parcelize
data class ProfileModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("photo_url") val photoUrl: String?,
    @SerializedName("Writer_by_user_id") val writerByUserId: WriterByUserId?,
    @SerializedName("is_following") val isFollowing: Boolean?,
    @SerializedName("user_id") val userId: Int?,
    @SerializedName("count_follower") val countFollower: Int?
) : Parcelable
