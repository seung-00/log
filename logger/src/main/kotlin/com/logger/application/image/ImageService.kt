package com.logger.application.image

import com.logger.model.image.Image
import com.logger.model.image.ImageRepository
import org.springframework.stereotype.Service

@Service
class ImageService(
  private val imageRepository: ImageRepository,
) {

  // TODO: 서버에서 이미지 크기 조절해주기
  fun getImage(imageId: String): Image {
    val image = imageRepository.retrieveImage(imageId)

    return image
  }
}
