package com.example.image_uploader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_image.view.*

class ImageListAdapter(
    var images: List<UploadableImage>,
    val onItemClick: ((UploadableImage) -> Unit)? = null
): RecyclerView.Adapter<ImageListViewHolder>() {

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_image, parent, false)
        return ImageListViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {

        val item = images[position]
        holder.setupView(item)

        holder.itemView.apply {
            setOnClickListener {
                onItemClick?.invoke(item)
            }
        }

    }

}

class ImageListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun setupView(item: UploadableImage) {

        view.text_view_image_title.text = item?.title
        view.text_view_image_progress.text = "Progress ${item.progress}"
        view.progress_bar_image_progress.progress = item?.progress
    }
}