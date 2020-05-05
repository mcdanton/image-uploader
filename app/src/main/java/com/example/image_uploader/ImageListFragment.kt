package com.example.image_uploader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.image_uploader.databinding.FragmentImageListBinding
import kotlinx.android.synthetic.main.fragment_image_list.*

class ImageListFragment : Fragment() {

    private val viewModel = ImageListViewModel()
    private lateinit var binding: FragmentImageListBinding
    private lateinit var recyclerView: RecyclerView
    private var adapter: ImageListAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentImageListBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.vm = viewModel

        recyclerView = binding.root.findViewById<RecyclerView>(R.id.image_list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity!!)

        setupObservers()

        return binding.root

    }

    private fun setupObservers() {

        viewModel.uploadedImages.observe(viewLifecycleOwner, Observer { uploadedImages ->

            if (adapter == null)
                adapter = ImageListAdapter(
                    images = uploadedImages,
                    onItemClick = ::showImageDetails
                )

            if (recyclerView.adapter == null)
                recyclerView.adapter = adapter

            adapter?.apply {
                images = uploadedImages
                notifyDataSetChanged()
            }

            if (uploadedImages.isNullOrEmpty())
                layout_no_uploaded_images.visibility = View.VISIBLE
            else
                layout_no_uploaded_images.visibility = View.GONE
        })

    }

    private fun showImageDetails(item: UploadableImage) {

        // Would never actually switch frags like this
        // Or cast activity like this
        val mainActivity = activity as MainActivity
        mainActivity.replaceFragment(R.layout.fragment_image_details, item)

    }

}