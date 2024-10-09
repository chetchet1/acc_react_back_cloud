package kr.co.seoulit.account.sys.common.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/base")
public class ExcelController {

    @PostMapping("/excel")
    public void getExcel(@RequestParam String sendData) throws Exception {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@진입");

        XSSFWorkbook xssfWb = null;
        XSSFSheet xssfSheet = null;
        XSSFRow xssfRow = null;
        XSSFCell xssfCell = null;

        try {
            String parameter = sendData.replace("\\", "").replace("[", "").replace("]", "").replace("}\"", "}").replace("\"{", "{");
            System.out.println("합잔데이터" + parameter);

            JSONObject jsonObject = JSONObject.fromObject(parameter);
            System.out.println("jsonObject" + jsonObject);

            int rowNo = 0;
            xssfWb = new XSSFWorkbook();
            xssfSheet = xssfWb.createSheet("합계잔액시산표");

            XSSFFont font = xssfWb.createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);

            CellStyle cellStyle_Title = xssfWb.createCellStyle();
            cellStyle_Title.setBorderTop(BorderStyle.THIN);
            cellStyle_Title.setBorderBottom(BorderStyle.THIN);
            cellStyle_Title.setBorderLeft(BorderStyle.THIN);
            cellStyle_Title.setBorderRight(BorderStyle.THIN);
            cellStyle_Title.setAlignment(HorizontalAlignment.CENTER);
            cellStyle_Title.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            cellStyle_Title.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle_Title.setFont(font);

            xssfSheet.setColumnWidth(0, (xssfSheet.getColumnWidth(5)) + (short) 1000);
            xssfSheet.setColumnWidth(1, (xssfSheet.getColumnWidth(5)) + (short) 1000);
            xssfSheet.setColumnWidth(2, (xssfSheet.getColumnWidth(5)) + (short) 5300);
            xssfSheet.setColumnWidth(3, (xssfSheet.getColumnWidth(3)) + (short) 1000);
            xssfSheet.setColumnWidth(4, (xssfSheet.getColumnWidth(4)) + (short) 1000);

            System.out.println("병합쪽");
            xssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));

            xssfRow = xssfSheet.createRow(rowNo++);
            xssfCell = xssfRow.createCell(0);
            xssfCell.setCellStyle(cellStyle_Title);
            xssfCell.setCellValue("합계잔액시산표");

            CellStyle cellStyle_Body = xssfWb.createCellStyle();
            cellStyle_Body.setAlignment(HorizontalAlignment.LEFT);

            xssfRow = xssfSheet.createRow(rowNo++);
            xssfCell = xssfRow.createCell(0);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("잔액");

            xssfCell = xssfRow.createCell(1);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("합계");

            xssfCell = xssfRow.createCell(2);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("과목");

            xssfCell = xssfRow.createCell(3);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("합계");

            xssfCell = xssfRow.createCell(4);
            xssfCell.setCellStyle(cellStyle_Body);
            xssfCell.setCellValue("잔액");

            System.out.println("반복문 전");

            int cnt = 1;
            while (true) {
                if (cnt > 1) {
                    if (parameter.indexOf(",{") != -1) {
                        parameter = parameter.substring(parameter.indexOf(",{") + 1, parameter.lastIndexOf("}") + 1);
                        jsonObject = JSONObject.fromObject(parameter);
                    } else {
                        break;
                    }
                }

                xssfRow = xssfSheet.createRow(rowNo++);
                xssfCell = xssfRow.createCell(0);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("debitsSumBalance"));

                xssfCell = xssfRow.createCell(1);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("debitsSum"));

                xssfCell = xssfRow.createCell(2);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("accountName"));

                xssfCell = xssfRow.createCell(3);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("creditsSum"));

                xssfCell = xssfRow.createCell(4);
                xssfCell.setCellStyle(cellStyle_Body);
                xssfCell.setCellValue(jsonObject.getString("creditsSumBalance"));

                cnt++;
            }

            String localFile = "C:\\excel\\합계잔액시산표.xlsx";
            File file = new File(localFile);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                xssfWb.write(fos);
            }

            if (xssfWb != null) xssfWb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
