package com.demo.samrach.exceluploader

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/categories")
class CategoryController(private val importer: CategoryExcelImporter) {

    @PostMapping("/import")
    fun importExcel(@RequestParam file: MultipartFile): ResponseEntity<String> {
        return try {
            importer.import(file)
            ResponseEntity.ok("Excel imported successfully.")
        } catch (e: Exception) {
            ResponseEntity.internalServerError().body("Failed to import: ${e.message}")
        }
    }
}