package isi.proiect.studentmanager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

public class PdfExportUtil {

//    public static ByteArrayOutputStream exportToPdf(List<String> headers, List<Map<String, Object>> rows) {
//        try {
//            Document document = new Document();
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            PdfWriter.getInstance(document, baos);
//
//            document.open();
//
//            addTable(document, headers, rows);
//
//            document.close();
//            return baos;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private static void addTable(Document document, List<String> headers, List<Map<String, Object>> rows)
//            throws DocumentException {
//
//        for (String header : headers) {
//            document.add(new Paragraph(header));
//        }
//
//        for (Map<String, Object> row : rows) {
//            for (String header : headers) {
//                document.add(new Paragraph(String.valueOf(row.get(header))));
//            }
//        }
//    }
public ByteArrayOutputStream createPdf(List<String> headers, List<Map<String, Object>> rows)
        throws DocumentException {
    ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
    Document document;
    document = new Document();
    PdfWriter.getInstance(document, pdfOutputStream);
    document.open();

    PdfPTable table = new PdfPTable(headers.size());
    addTableHeader(table, headers);
    addRows(table, rows);

    document.add(table);
    document.close();

    return pdfOutputStream;
}

    public void addTableHeader(PdfPTable table, List<String> headers) {
        headers.forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }

    public void addRows(PdfPTable table, List<Map<String, Object>> rows) {
        for (Map<String, Object> row : rows) {
            for (Object value : row.values()) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(value.toString()));
                table.addCell(cell);
            }
        }
    }
}
