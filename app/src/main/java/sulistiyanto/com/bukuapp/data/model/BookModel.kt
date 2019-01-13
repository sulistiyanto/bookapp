package sulistiyanto.com.bukuapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookModel(val id: Int, val title: String, val price: String): Parcelable