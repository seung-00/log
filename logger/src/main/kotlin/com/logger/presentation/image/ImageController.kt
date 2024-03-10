package com.logger.presentation.image

import com.logger.application.image.ImageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = arrayOf("*"))
class ImageController(
  private val imageService: ImageService,
) {
  private val logger: Logger = LoggerFactory.getLogger(ImageController::class.java)

  @GetMapping("/api/v1/images/{imageId}")
  fun getImage(@PathVariable imageId: String): ResponseEntity<Resource> {
    return try {
      val imageResource = UrlResource(imageService.getImage(imageId).url)

      ResponseEntity.ok()
        .contentType(MediaType.IMAGE_PNG)
        .body(imageResource)
    } catch (e: Exception) {
      logger.error("Error while trying to get image", e)
      ResponseEntity.notFound().build()
    }
  }
}

