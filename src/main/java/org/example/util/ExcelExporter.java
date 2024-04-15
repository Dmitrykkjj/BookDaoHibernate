package org.example.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.nio.file.*;

public class ExcelExporter {
    public static void exportToExcel(List<Book> books, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Path parentDir = path.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            try (Workbook workbook = new XSSFWorkbook();
                 FileOutputStream outputStream = new FileOutputStream(path.toFile())) {

                Sheet sheet = workbook.createSheet("Books");

                Row headerRow = sheet.createRow(0);
                String[] headers = {"ID", "Author", "Title", "Year"};
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                }

                int rowNum = 1;
                for (Book book : books) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(book.getId());
                    row.createCell(1).setCellValue(book.getAuthorName());
                    row.createCell(2).setCellValue(book.getTitle());
                    row.createCell(3).setCellValue(book.getYear());
                }

                workbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
