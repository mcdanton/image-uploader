package com.example.image_uploader

import okhttp3.OkHttpClient

object SharedOkHttpClient {

    val singleton = OkHttpClient.Builder().build()

}