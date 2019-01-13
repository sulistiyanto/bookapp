package sulistiyanto.com.bukuapp.di.subcomponent

import dagger.Subcomponent
import sulistiyanto.com.bukuapp.ui.bookByGenre.BookGenreActivity
import sulistiyanto.com.bukuapp.ui.detailBook.DetailBookActivity
import sulistiyanto.com.bukuapp.ui.detailProfile.ProfileActivity

@Subcomponent
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ActivityComponent
    }

    fun inject(detailBookActivity: DetailBookActivity)
    fun inject(profileActivity: ProfileActivity)
    fun inject(bookGenreActivity: BookGenreActivity)
}