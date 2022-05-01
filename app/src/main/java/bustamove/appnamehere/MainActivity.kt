package bustamove.appnamehere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import bustamove.appnamehere.ui.HomeFragment
import bustamove.appnamehere.ui.PlaylistFragment
import bustamove.appnamehere.ui.SettingsFragment
import bustamove.appnamehere.ui.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

private lateinit var pager: ViewPager
private lateinit var tab: TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(PlaylistFragment(), "Playlist")
        adapter.addFragment(SettingsFragment(), "Settings")

        pager.adapter = adapter

        tab.setupWithViewPager(pager)
    }
}