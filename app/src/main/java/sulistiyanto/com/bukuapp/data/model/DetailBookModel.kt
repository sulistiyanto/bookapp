package sulistiyanto.com.bukuapp.data.model

import com.google.gson.annotations.SerializedName

data class DetailBookResponseModel(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("result") val result: DetailBookModel?
)

data class DetailBookModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("synopsis") val synopsis: String?,
    @SerializedName("cover_url") val coverURl: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("writer_id") val writerId: Int?,
    @SerializedName("download") val download: Int?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("updated_at") val updatedAt: String?,
    @SerializedName("category") val category: String?,
    @SerializedName("nominasi") val nomination: String?,
    @SerializedName("challenge_id") val challengeId: Int?,
    @SerializedName("Writer_by_writer_id") val writerByWriterId: WriterByUserId?,
    @SerializedName("book_url") val bookUrl: String?,
    @SerializedName("full_price") val fullPrice: Int?,
    @SerializedName("full_purchase") val fullPurchase: Boolean?,
    @SerializedName("time_to_vote") val timeToVote: Boolean?,
    @SerializedName("vote_count") val voteCount: String?,
    @SerializedName("voted") val voted: Boolean?,
    @SerializedName("desc") val desc: String?,
    @SerializedName("isNew") val isNew: Boolean?,
    @SerializedName("url_landing") val urlLanding: String?,
    @SerializedName("genres") val genres: List<GenreModel>?,
    @SerializedName("is_update") val isUpdate: Boolean?,
    @SerializedName("view_count") val viewCount: Int?,
    @SerializedName("User_review") val userReview: String?,
    @SerializedName("average_rate") val averageRate: Int?,
    @SerializedName("decimal_rate") val decimalRate: Float?,
    @SerializedName("reviews") val reviews: List<ReviewModel>?
)