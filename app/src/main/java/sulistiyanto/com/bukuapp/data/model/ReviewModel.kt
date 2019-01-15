package sulistiyanto.com.bukuapp.data.model

import com.google.gson.annotations.SerializedName

data class ReviewModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("user_id") val userId: Int?,
    @SerializedName("rating") val rating: Int?,
    @SerializedName("review") val review: String?,
    @SerializedName("updated_at") val updateAtd: String?,
    @SerializedName("User_by_reviewer_id") val userByUserId: UserByUserId?)