package bustamove.appnamehere

import android.Manifest
import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.content.Intent
import android.app.PendingIntent
import android.content.Context
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import bustamove.appnamehere.activity.ActivityTransitionReceiver
import bustamove.appnamehere.activity.ActivityTransitionsUtility
import bustamove.appnamehere.activity.Constant
import bustamove.appnamehere.ui.HomeFragment
import bustamove.appnamehere.ui.PlaylistFragment
import bustamove.appnamehere.ui.SettingsFragment
import bustamove.appnamehere.ui.ViewPagerAdapter
import com.google.android.gms.common.GooglePlayServicesUtil
import com.google.android.gms.location.ActivityRecognition
import com.google.android.gms.location.ActivityRecognitionClient
import com.google.android.gms.location.ActivityTransitionResult
import com.google.android.material.tabs.TabLayout
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

private lateinit var pager: ViewPager
private lateinit var tab: TabLayout

@SuppressLint("StaticFieldLeak")
//private lateinit var activityClient: ActivityRecognitionClient
//private lateinit var userPrefs : SharedPreferences

//private var activityInfo : String = ""

class MainActivity : AppCompatActivity()/*, EasyPermissions.PermissionCallbacks*/ {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
//        activityClient = ActivityRecognition.getClient(this)
//        userPrefs = PreferenceManager.getDefaultSharedPreferences(this)



        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(PlaylistFragment(), "Playlist")
        adapter.addFragment(SettingsFragment(), "Settings")

        pager.adapter = adapter
        tab.setupWithViewPager(pager)

        val button: ImageButton = findViewById(R.id.playPause)
        button.setOnClickListener {
            
        }
//        getActivityTrackingPermission()
//        registerForUpdates()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG)
            .show()
    }

    // Get Permission
    //Require Android 10
//    @RequiresApi(Build.VERSION_CODES.Q)
//    private fun getActivityTrackingPermission() {
//        EasyPermissions.requestPermissions(
//            this,
//            "This is a necessary permission requirement",
//            Constant.Constants.REQUEST_CODE_ACTIVITY_TRANSITION,
//            Manifest.permission.ACTIVITY_RECOGNITION
//        )
//    }
//
//    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
//        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
//            AppSettingsDialog.Builder(this).build().show()
//        } else {
//            getActivityTrackingPermission()
//        }
//    }

    //Register for ActivityTransitionUpdates
//    private fun registerForUpdates() {
//        activityClient.requestActivityTransitionUpdates(ActivityTransitionsUtility.getActivityTransitionRequest(), atrPendingEvent())
//    }
//
//    //Unregister for ActivityTransitionUpdates
//    private fun unregisterForUpdates(){
//        activityClient.removeActivityTransitionUpdates(atrPendingEvent()).addOnSuccessListener { atrPendingEvent().cancel() }
//    }

//    private fun atrPendingEvent(): PendingIntent {
//        val intent = Intent(this, this::class.java)
//        return PendingIntent.getBroadcast(
//            this,
//            Constant.Constants.REQUEST_CODE_INTENT_ACTIVITY_TRANSITION,
//            intent,
//            PendingIntent.FLAG_UPDATE_CURRENT
//        )
//    }
}