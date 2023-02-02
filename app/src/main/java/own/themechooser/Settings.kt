package own.themechooser

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class Settings : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    class SettingsFragment : PreferenceFragmentCompat() {

        private lateinit var sharedPref: SharedPreferences
        private lateinit var sharedPrefListener: SharedPreferences.OnSharedPreferenceChangeListener

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.settings, rootKey)
            sharedPref = PreferenceManager.getDefaultSharedPreferences(requireContext())
            val editor: SharedPreferences.Editor = sharedPref.edit()
            sharedPrefListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPref, key ->

                val setkey = sharedPref.getString(key, "default")
                Log.i("ThemeChanger", "setkey: "+setkey)
                editor.putString(setkey, "default")
                editor.apply()
            }
            sharedPref.registerOnSharedPreferenceChangeListener(sharedPrefListener)
        }

        override fun onDestroyView() {
            super.onDestroyView()
            sharedPref.unregisterOnSharedPreferenceChangeListener(sharedPrefListener)
        }
    }
}