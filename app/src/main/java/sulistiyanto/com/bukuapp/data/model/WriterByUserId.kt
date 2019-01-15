package sulistiyanto.com.bukuapp.data.model

import com.google.gson.annotations.SerializedName

data class WriterByUserId(
    @SerializedName("id") val id: Int?,
    @SerializedName("user_id") val userId: Int?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("kelas") val kelas: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("schedule_task") val scheduleTask: String?,
    @SerializedName("royalty_id") val royaltyId: Int?,
    @SerializedName("User_by_user_id") val userByUserId: UserByUserId?
)