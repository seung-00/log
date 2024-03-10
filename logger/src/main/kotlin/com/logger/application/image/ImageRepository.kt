package com.logger.application.image

import com.logger.model.image.Image

interface ImageRepository {
  fun retrieveImage(imageId: String): Image
}
