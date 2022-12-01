package com.example.myapplication111122

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication111122.databinding.ActivityMainBinding
import com.example.myapplication111122.databinding.FragmentMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw RuntimeException("FragmentEmptyBinding is null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash)

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            _binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val navHost =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHost.navController
            initBottomBar()
        }

    }

    private fun initBottomBar() {
        val shoppingCartItem =
            binding.bottomNavigationView.getOrCreateBadge(R.id.shoppingCartFragment)
        shoppingCartItem.number = 2
        shoppingCartItem.isVisible = true
    }

}