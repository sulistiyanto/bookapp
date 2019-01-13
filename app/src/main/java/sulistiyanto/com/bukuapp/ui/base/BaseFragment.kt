package sulistiyanto.com.bukuapp.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View? = inflater.inflate(getFragmentLayout(), container, false)
        initInjection()
        initLayout(rootView)
        return rootView
    }

    protected abstract fun getFragmentLayout(): Int
    protected abstract fun initInjection()
    protected abstract fun initLayout(rootView: View?)
}
