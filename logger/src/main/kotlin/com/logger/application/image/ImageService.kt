package com.logger.application.image

import com.logger.model.image.Image

interface ImageService {
  fun getImage(imageId: String): Image
}
