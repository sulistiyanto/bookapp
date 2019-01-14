package sulistiyanto.com.bukuapp.utilities

import android.content.Context
import android.net.NetworkInfo
import android.net.ConnectivityManager
import javax.inject.Inject
import android.os.Build
import android.util.Log
import javax.inject.Singleton

@Singleton
class ConnectingNetwork @Inject constructor(val context: Context) {

    fun isConnecting(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val networks = connectivityManager.allNetworks
            var networkInfo: NetworkInfo
            for (mNetwork in networks) {
                networkInfo = connectivityManager.getNetworkInfo(mNetwork)
                if (networkInfo.state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        } else {
            if (connectivityManager != null) {
                val info = connectivityManager.allNetworkInfo
                if (info != null) {
                    for (anInfo in info) {
                        if (anInfo.state == NetworkInfo.State.CONNECTED) {
                            Log.d("Network", "NETWORKNAME: " + anInfo.typeName)
                            return true
                        }
                    }
                }
            }
        }
        return false
    }
}