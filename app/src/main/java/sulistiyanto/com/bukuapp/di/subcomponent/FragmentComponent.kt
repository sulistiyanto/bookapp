package sulistiyanto.com.bukuapp.di.subcomponent

import dagger.Subcomponent
import sulistiyanto.com.bukuapp.ui.book.BookFragment
import sulistiyanto.com.bukuapp.ui.genre.GenreFragment
import sulistiyanto.com.bukuapp.ui.profile.ProfileFragment

@Subcomponent
interface FragmentComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentComponent
    }

    fun inject(bookFragment: BookFragment)
    fun inject(genreFragment: GenreFragment)
    fun inject(profileFragment: ProfileFragment)
}