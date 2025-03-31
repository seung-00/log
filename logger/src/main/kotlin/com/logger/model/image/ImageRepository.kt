package com.logger.model.image

interface ImageRepository {
  fun retrieveImage(imageId: String): Image
}
