package com.example.image_uploader

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageListViewModel: ViewModel() {

    private val repository = ImageUploadRepository()

    val uploadedImages = MutableLiveData<List<UploadableImage>>(listOf())


    fun uploadImage() {
        // Have to simulate image selected to upload
        val image = UploadableImage("Cool Image 1", 50, false, "")
        repository.uploadImage(image)
    }

    fun loadMockImages() {
        val imageList = listOf<UploadableImage>(
            UploadableImage("Cool Image 1", 50, false, ""),
            UploadableImage("Cool Image 2", 30, false, ""),
            UploadableImage("Cool Image 3", 100, true, "")
            )

        uploadedImages.value = imageList

    }

}