package com.example.image_uploader.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.image_uploader.view_models.ImageViewModel
import com.example.image_uploader.UploadableImage
import com.example.image_uploader.databinding.FragmentImageDetailsBinding

class ImageDetailsFragment : Fragment() {

    private val viewModel =
        ImageViewModel()
    private lateinit var binding: FragmentImageDetailsBinding


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentImageDetailsBinding.inflate(inflater, container, false)


        binding.lifecycleOwner = this
        binding.vm = viewModel

        val bundle = arguments
        val obj = bundle!!.getSerializable("PASSED_UPLOADED_IMAGE") as UploadableImage

        viewModel.imageTitle.value = obj.title
        viewModel.imageProgress.value = obj.progress

        return binding.root

    }

}