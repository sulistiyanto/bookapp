package sulistiyanto.com.bukuapp.data.model

import com.google.gson.annotations.SerializedName

data class BookResponseModel(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("result") val result: List<BookModel>?
)

data class BookModel(@SerializedName("id") val id: Int?,
                     @SerializedName("title") val title: String?,
                     @SerializedName("writer_id") val writerId: Int?,
                     @SerializedName( "cover_url") val coverUrl: String?,
                     @SerializedName( "created_at") val createdAt: String?,
                     @SerializedName("status") val status: String?,
                     @SerializedName("category") val category: String?,
                     @SerializedName("Writer_by_writer_id") val writerByWriterId: WriterByUserId?,
                     @SerializedName("book_url") val bookUrl: String?,
                     @SerializedName("isNew") val isNew: Boolean?,
                     @SerializedName("is_update") val isUpdate: Boolean?,
                     @SerializedName("book_id") val bookId: Int?,
                     @SerializedName("view_count") val viewCount: Int?,
                     @SerializedName("rate_sum") val rateSum: Float?,
                     @SerializedName("chapter_count") val chapterCount: Int?)