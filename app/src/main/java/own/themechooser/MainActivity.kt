package own.themechooser

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import own.themechooser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var currentTheme: String? = "aqua"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //settheme//
        currentTheme =
            PreferenceManager.getDefaultSharedPreferences(this).getString("THEME_KEY", "default")
        Log.i("ThemeChanger", "currenttheme: " + currentTheme)
        if (currentTheme == "default") {
            setTheme(R.style.Default)
        } else if (currentTheme == "white") {
            setTheme(R.style.White)
        } else if (currentTheme == "whitest") {
            setTheme(R.style.Whitest)
        } else if (currentTheme == "mixedblue") {
            setTheme(R.style.MixedBlue)
        } else if (currentTheme == "darkblue") {
            setTheme(R.style.DarkBlue)
        } else if (currentTheme == "orange") {
            setTheme(R.style.Orange)
        } else if (currentTheme == "dark") {
            setTheme(R.style.Dark)
        } else if (currentTheme == "black") {
            setTheme(R.style.Black)
        } else if (currentTheme == "green") {
            setTheme(R.style.Green)
        } else if (currentTheme == "gray") {
            setTheme(R.style.Gray)
        } else if (currentTheme == "blackaqua") {
            setTheme(R.style.BlackAqua)
        } else if (currentTheme == "blackneongreen") {
            setTheme(R.style.BlackNeonGreen)
        }


        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)





        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_settings) {
            val intentSetting = Intent(this, Settings::class.java)
            startActivity(intentSetting)
        }
        return super.onOptionsItemSelected(item)
    }





}