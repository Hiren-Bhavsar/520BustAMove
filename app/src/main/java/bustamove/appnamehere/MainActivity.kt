package bustamove.appnamehere

import android.Manifest
import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import bustamove.appnamehere.activity.Constant
import bustamove.appnamehere.ui.HomeFragment
import bustamove.appnamehere.ui.PlaylistFragment
import bustamove.appnamehere.ui.SettingsFragment
import bustamove.appnamehere.ui.ViewPagerAdapter
import com.google.android.gms.location.ActivityRecognition
import com.google.android.gms.location.ActivityRecognitionClient
import com.google.android.material.tabs.TabLayout
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

private lateinit var pager: ViewPager
private lateinit var tab: TabLayout

@SuppressLint("StaticFieldLeak")
private lateinit var activityClient: ActivityRecognitionClient
private lateinit var userPrefs : SharedPreferences

class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        activityClient = ActivityRecognition.getClient(this)
        userPrefs = PreferenceManager.getDefaultSharedPreferences(this)



        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(PlaylistFragment(), "Playlist")
        adapter.addFragment(SettingsFragment(), "Settings")

        pager.adapter = adapter
        tab.setupWithViewPager(pager)

        getActivityTrackingPermission()
    }

    // Get Permission
    //Require Android 10
    @RequiresApi(Build.VERSION_CODES.Q)
    private fun getActivityTrackingPermission() {
        EasyPermissions.requestPermissions(
            this,
            "This is a necessary permission requirement",
            Constant.Constants.REQUEST_CODE_ACTIVITY_TRANSITION,
            Manifest.permission.ACTIVITY_RECOGNITION
        )
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        TODO("Not yet implemented")
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            getActivityTrackingPermission()
        }
    }
}