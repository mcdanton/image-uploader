package com.example.image_uploader

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageListViewModel: ViewModel() {

    private val repository = ImageUploadRepository()

    val uploadedImages = MutableLiveData<List<UploadableImage>>(listOf())


    fun uploadImage() {
        val image = UploadableImage("Cool Image 1", 50, false, "")
        repository.uploadImage(image)
    }

}