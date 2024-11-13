package com.example.testprojeect

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.lifecycleScope
import com.example.testprojeect.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun getResources(): Resources {
        val resources = super.getResources()
        val widthPixels = resources.displayMetrics.widthPixels.toFloat()
        val heightPixels = resources.displayMetrics.heightPixels.toFloat()
        //dp修改方法
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
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
    }

    private fun printHelloWorld() {
        Log.d("TestDemo", "Hello,World!")
    }
}