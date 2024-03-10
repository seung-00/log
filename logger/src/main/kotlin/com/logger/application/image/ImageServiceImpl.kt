package com.logger.application.image

import com.logger.model.image.Image
import org.springframework.stereotype.Service

@Service
internal class ImageServiceImpl(
  private val imageRepository: ImageRepository
) : ImageService {

  // TODO: 서버에서 이미지 크기 조절해주기
  override fun getImage(imageId: String): Image {
    val image = imageRepository.retrieveImage(imageId)

    return image
  }
}
