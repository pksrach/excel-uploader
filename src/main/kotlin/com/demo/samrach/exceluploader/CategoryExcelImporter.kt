package com.demo.samrach.exceluploader

import jakarta.transaction.Transactional
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class CategoryExcelImporter(
    private val categoryRepository: CategoryRepository
) {
    @Transactional
    fun import(file: MultipartFile) {
        val workbook = XSSFWorkbook(file.inputStream)
        val sheet = workbook.getSheetAt(0)
        val listCategory = mutableListOf<Category>()

        for (i in 0..sheet.lastRowNum) {
            val row = sheet.getRow(i) ?: continue

            // Skip header if it has "name" in first cell
            val firstCell = row.getCell(0)
            println("firstCell?.stringCellValue ->" + firstCell?.stringCellValue)
            if (firstCell?.stringCellValue?.equals("name", ignoreCase = true) == true) continue

            val name = row.getCell(0)?.stringCellValue?.trim() ?: continue
            val note = row.getCell(1)?.stringCellValue?.trim()

            listCategory.add(Category(name = name, note = note))

            println("Skipping row $i: missing name")

        }

        categoryRepository.saveAll(listCategory)
        workbook.close()
    }

}