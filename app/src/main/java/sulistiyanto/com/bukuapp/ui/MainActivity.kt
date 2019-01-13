package sulistiyanto.com.bukuapp.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import sulistiyanto.com.bukuapp.R
import sulistiyanto.com.bukuapp.ui.book.BookFragment
import sulistiyanto.com.bukuapp.ui.genre.GenreFragment
import sulistiyanto.com.bukuapp.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private var fragmentTransaction: FragmentTransaction? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceItem(GenreFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorites -> {
                replaceItem(BookFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cart -> {
                replaceItem(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //add home fragment
        fragmentTransaction = supportFragmentManager?.beginTransaction()
        fragmentTransaction?.add(R.id.container, GenreFragment())
        fragmentTransaction?.commit()
    }

    private fun replaceItem(fragment: Fragment) {
        fragmentTransaction = supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.container, fragment)
        fragmentTransaction?.commit()
    }
}
