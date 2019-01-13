package sulistiyanto.com.bukuapp.ui.detailBook

import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.application.App
import sulistiyanto.com.bukuapp.di.subcomponent.ActivityComponent
import sulistiyanto.com.bukuapp.ui.base.BaseActivity

class DetailBookActivity : BaseActivity() {

    override fun initInjection() {
        val activityComponent: ActivityComponent = (applicationContext as App)
            .appComponent
            .activityComponent()
            .build()
        activityComponent.inject(this)
    }

    override fun initLayout() {
        setContentView(R.layout.activity_detail_book)
    }

}