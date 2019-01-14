package sulistiyanto.com.bukuapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class BookResponseModel(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("result") val result: List<BookModel>?
)

@Parcelize
data class BookModel(@SerializedName("id") val id: Int?,
                     @SerializedName("title") val title: String?,
                     @SerializedName("writer_id") val writerId: Int?,
                     @SerializedName( "cover_url") val coverUrl: String?,
                     @SerializedName( "created_at") val createdAt: String?,
                     @SerializedName("status") val status: String?,
                     @SerializedName("category") val category: String?,
                     @SerializedName("Writer_by_writer_id") val WriterByWriterId: WriterByUserId?): Parcelable