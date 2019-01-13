package sulistiyanto.com.bukuapp.ui.bookByGenre

import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.di.subcomponent.ActivityComponent
import sulistiyanto.com.bukuapp.ui.base.BaseActivity

class BookGenreActivity : BaseActivity() {

    override fun initInjection() {
        val activityComponent: ActivityComponent = (applicationContext as App)
            .appComponent
            .activityComponent()
            .build()
        activityComponent.inject(this)
    }

    override fun initLayout() {
        setContentView(R.layout.activity_book_genre)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Buku"
    }
}
