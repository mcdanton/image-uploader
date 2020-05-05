package com.example.image_uploader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val imageListFragment by lazy { ImageListFragment() }
    private val imageDetailsFragment by lazy { ImageDetailsFragment() }
    var currentFragment = R.layout.fragment_image_list


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Allows fragments to easily pass in fragment id for
            // Main Activity to access
            replaceFragment(R.layout.fragment_image_list)
        }

    }

    private fun replaceFragment(fragmentId: Int?) {

        // Include "extra" case here for safety in case unsupported Frag Id passed
        val fragment = when(fragmentId) {
            R.layout.fragment_image_list -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                imageListFragment
            }
            R.layout.fragment_image_details -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                imageDetailsFragment
            }
            else -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                imageListFragment
            }
        }

        supportFragmentManager
            .beginTransaction().apply {
                replace(R.id.main, fragment)
                addToBackStack(this::class.java.simpleName)
                commit()
            }
    }

}
