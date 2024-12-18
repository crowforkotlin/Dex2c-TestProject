package com.example.testproject

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.lifecycleScope
import com.example.testproject.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun getResources(): Resources {
        val resources = super.getResources()
        val widthPixels = resources.displayMetrics.widthPixels.toFloat()
        val heightPixels = resources.displayMetrics.heightPixels.toFloat()
        if (widthPixels > heightPixels) {
            if (widthPixels / 1024 * 600 > heightPixels) {
                resources.displayMetrics.density = heightPixels / 600
            } else {
                resources.displayMetrics.density = widthPixels / 1024
            }
        } else {
            resources.displayMetrics.density = widthPixels / 1024
        }
        return resources
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()
//        WindowInsetsControllerCompat(window, binding.root).isAppearanceLightStatusBars = false
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { _, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.root.updateLayoutParams<FrameLayout.LayoutParams> {
                topMargin = systemBars.top
            }
            binding.root.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }
        lifecycleScope.launch { }
        initView()
        printHelloWorld()
    }

    private fun initView() {
        // TODO
        lifecycleScope.launch {
            delay(1000)
        }
    }

    private fun printHelloWorld() {
        Log.d("TestDemo", "Hello,World!")
    }
}