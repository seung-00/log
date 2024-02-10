package com.logger.presentation.image

import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

@RestController
@CrossOrigin(origins = arrayOf("*"))
class ImageController {

  @GetMapping("/api/v1/images/{imageId}")
  fun getImage(@PathVariable imageId: String): ResponseEntity<Resource> {
    try {
      val filePath = "file:/Users/seungyoungoh/Library/Mobile%20Documents/com~apple~CloudDocs/home/workspace/log/public/asset/images/$imageId"
      val imageResource = UrlResource(filePath)

      return ResponseEntity.ok()
        .contentType(MediaType.IMAGE_PNG)
        .body(imageResource)
    } catch (e: IOException) {
      return ResponseEntity.notFound().build()
    }
  }
}

