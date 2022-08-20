package kg.example.lovecalculator.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class Prefs @Inject constructor(private val prefs: SharedPreferences) {

    fun saveState() {
        prefs.edit().putBoolean("board", true).apply()
    }

    fun getSaveState(): Boolean {
        return prefs.getBoolean("board", false)
    }
}