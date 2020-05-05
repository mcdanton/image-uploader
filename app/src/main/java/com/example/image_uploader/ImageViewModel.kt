package com.example.image_uploader

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel: ViewModel() {

    private val repository = ImageUploadRepository()

    val imageTitle = MutableLiveData<String>("Image Title")
    val imageProgress = MutableLiveData<Int>(0)

    val imageUpdates = MediatorLiveData<Int>().apply {
        addSource(imageProgress) {
            // postValue handles data on background thread
            imageProgress.postValue(it)
        }
    }

}