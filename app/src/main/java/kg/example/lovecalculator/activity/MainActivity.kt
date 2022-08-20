package kg.example.lovecalculator.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kg.example.lovecalculator.R
import kg.example.lovecalculator.databinding.ActivityMainBinding
import kg.example.lovecalculator.prefs.Prefs
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    @Inject
    lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavController()
    }

    private fun initNavController() {
        val navController = findNavController(R.id.fragment_container_main_activity)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.testFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }

        if (prefs.getSaveState() == false) {
            navController.navigate(R.id.boardFragment)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}






