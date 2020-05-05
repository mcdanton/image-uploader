package com.example.image_uploader.view_models

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.image_uploader.ImageUploadRepository

class ImageViewModel: ViewModel() {

    private val repository = ImageUploadRepository()

    val imageTitle = MutableLiveData<String>("Image Title")
    val imageProgress = MutableLiveData<Int>(0)

    val imageUpdates = MediatorLiveData<Int>().apply {
        addSource(repository.imageProgress) {
            // postValue handles data on background thread
            imageProgress.postValue(it)
        }
    }

    val imageProgressLabel = MediatorLiveData<String>().apply {
        addSource(imageProgress) {
            // postValue handles data on background thread
            value = "Progress $it"
        }
    }

}