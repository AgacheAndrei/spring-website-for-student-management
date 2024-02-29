package isi.proiect.studentmanager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelExportUtil {
    public ByteArrayOutputStream createExcel(List<String> headers, List<Map<String, Object>> rows) throws IOException {
        ByteArrayOutputStream excelOutputStream = new ByteArrayOutputStream();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        addHeaderRow(sheet, headers);
        addDataRows(sheet, rows);

        workbook.write(excelOutputStream);
        workbook.close();

        return excelOutputStream;
    }

    public void addHeaderRow(Sheet sheet, List<String> headers) {
        Row headerRow = sheet.createRow(0);

        for (int colIndex = 0; colIndex < headers.size(); colIndex++) {
            Cell cell = headerRow.createCell(colIndex);
            cell.setCellValue(headers.get(colIndex));
        }
    }

    public void addDataRows(Sheet sheet, List<Map<String, Object>> rows) {
        int rowIndex = 1;

        for (Map<String, Object> row : rows) {
            Row dataRow = sheet.createRow(rowIndex++);

            int colIndex = 0;
            for (Object value : row.values()) {
                Cell cell = dataRow.createCell(colIndex++);
                cell.setCellValue(value.toString());
            }
        }
    }
}
