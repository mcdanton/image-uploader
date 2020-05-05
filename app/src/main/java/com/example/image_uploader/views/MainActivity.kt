package com.example.image_uploader.views

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.image_uploader.R
import com.example.image_uploader.UploadableImage

class MainActivity : AppCompatActivity() {

    private val imageListFragment by lazy { ImageListFragment() }
    private val imageDetailsFragment by lazy { ImageDetailsFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            replaceFragment(R.layout.fragment_image_list)
        }

    }

    fun replaceFragment(fragmentId: Int?, selectedImage: UploadableImage? = null) {

        // Include "extra" case here for safety in case unsupported Frag Id passed
        val fragment = when(fragmentId) {
            R.layout.fragment_image_list -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                imageListFragment
            }
            R.layout.fragment_image_details -> {
                val bundle = Bundle()
                bundle.putSerializable("PASSED_UPLOADED_IMAGE", selectedImage)
                imageDetailsFragment.arguments = bundle
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            replaceFragment(R.layout.fragment_image_list, null)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
