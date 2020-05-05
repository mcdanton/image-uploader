package com.example.image_uploader

import java.io.Serializable

class UploadableImage(var title: String,
                      var progress: Int,
                      var hasCompleted: Boolean,
                      var imageUrl: String) : Serializable {

}