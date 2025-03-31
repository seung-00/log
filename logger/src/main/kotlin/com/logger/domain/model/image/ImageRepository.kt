package com.logger.domain.model.image

interface ImageRepository {
  fun retrieveImage(imageId: String): Image
}
