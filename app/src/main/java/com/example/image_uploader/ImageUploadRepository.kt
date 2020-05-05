package com.example.image_uploader

import androidx.lifecycle.MutableLiveData
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ImageUploadRepository {

    val imageProgress = MutableLiveData<Int>(0)


    fun uploadImage(image: UploadableImage) {

        val url = "https://your-url-here.com"

        val request = Request.Builder()
            .url(url)
            .build()

        SharedOkHttpClient.singleton.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                // Using mock data instead of response
                // If no cache layer than update response here
                // If cache layer, save response to cache and
                // have ImageViewModel listen to cache notifications

                imageProgress.postValue(100)
            }

            override fun onFailure(call: Call, e: IOException) {
                // Handle Failure here - perhaps show Alert Dialog to user
                // and log error to servers
            }

        })

    }

}