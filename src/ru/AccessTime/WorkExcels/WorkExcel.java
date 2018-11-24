package ru.AccessTime.WorkExcels;

import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import ru.AccessTime.Serviceman.Condition;
import ru.AccessTime.Serviceman.Serviceman;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WorkExcel { // НЕЗАБЫТЬ ЗАКРЫТЬ FileOutputStream
    private Date date;
    private SimpleDateFormat simpleDateFormat;





    public void creatNewExcel (ObservableList<Serviceman> servicemenListAccounting, String time, String data, String  percent) {
        Workbook wb = new HSSFWorkbook();
        OutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("D:/Обучение/Программирование/Cod/AccessTime/AccountingInExcel/workbook1.xls");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Sheet sheet1 = wb.createSheet("Учет прибытия по состоянию");

        Map<String, Object> properties = new HashMap<String, Object>();
        creatMyStyle(properties);

        Row row0 = sheet1.createRow(0);
        createCell(wb, row0,0, "Дата:", HorizontalAlignment.LEFT, VerticalAlignment.CENTER, properties);
        createCell(wb, row0,1, data, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);

        createCellNotBorder(wb, row0,2, "СПИСОК", HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
        sheet1.addMergedRegion(new CellRangeAddress(0,0,2,6));
        Row row1 = sheet1.createRow(1);
        createCell(wb, row1,0, "Время:", HorizontalAlignment.LEFT, VerticalAlignment.CENTER, properties);
        createCell(wb, row1,1, time, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCellNotBorder(wb, row1,2, "прибытия личного состава", HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,2,6));

        Row row3 = sheet1.createRow(3);
        createCell(wb, row3,0, "Процент:", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCell(wb, row3,1, percent, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);


        Row row4 = sheet1.createRow(4);
        createCell(wb, row4,0, "№ п/п", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCell(wb, row4,1, "Должность", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCell(wb, row4,2, "Фамилия", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCell(wb, row4,3, "Имя", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCell(wb, row4,4, "Отчество", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCell(wb, row4,5, "Состояние", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCell(wb, row4,6, "Время на прибытие", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
        createCell(wb, row4,7, "Прибыл", HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);

        int xRow = 5;
        int NPP = 1;
        for (Serviceman ser: servicemenListAccounting) {
            Row rowFor = sheet1.createRow(xRow);
            createCell(wb, rowFor,0, NPP, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
            createCell(wb, rowFor,1, ser.getPosition(), HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
            createCell(wb, rowFor,2, ser.getSurname(), HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
            createCell(wb, rowFor,3, ser.getName(), HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
            createCell(wb, rowFor,4, ser.getPatronymic(), HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
            createCell(wb, rowFor,5, Condition.getByCode(ser.getCondition()).getText(), HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties); //
            createCell(wb, rowFor,6, ser.getChPlus(), HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
            createCell(wb, rowFor,7, ser.getTimeAcc(), HorizontalAlignment.CENTER, VerticalAlignment.CENTER, properties);
            xRow++;
            NPP++;
        }

        for (int i = 0; i < 8; i++) {
            sheet1.autoSizeColumn (i);
        }

        try {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }   //wb.write(fileOut);
        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   //wb.close();
        openExcel ();


    }

    public void creatMyStyle(Map<String, Object> properties) {
        properties.put(CellUtil.BORDER_TOP, BorderStyle.MEDIUM);
        properties.put(CellUtil.BORDER_BOTTOM, BorderStyle.MEDIUM);
        properties.put(CellUtil.BORDER_LEFT, BorderStyle.MEDIUM);
        properties.put(CellUtil.BORDER_RIGHT, BorderStyle.MEDIUM);
        properties.put(CellUtil.TOP_BORDER_COLOR, IndexedColors.BLACK.getIndex());
        properties.put(CellUtil.BOTTOM_BORDER_COLOR, IndexedColors.BLACK.getIndex());
        properties.put(CellUtil.LEFT_BORDER_COLOR, IndexedColors.BLACK.getIndex());
        properties.put(CellUtil.RIGHT_BORDER_COLOR, IndexedColors.BLACK.getIndex());
    }

    public void openExcel () {
        try {
            Desktop.getDesktop().open(new java.io.File("D:/Обучение/Программирование/Cod/AccessTime/AccountingInExcel/workbook1.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void createCell(Workbook wb, Row row, int column, String stringCellValue, HorizontalAlignment halign, VerticalAlignment valign, Map<String, Object> properties) {
        Cell cell = row.createCell(column);
        cell.setCellValue(stringCellValue);
        CellUtil.setAlignment(cell, halign);
        CellUtil.setVerticalAlignment(cell, valign);
        CellUtil.setCellStyleProperties(cell, properties);


    }
    private void createCell(Workbook wb, Row row, int column, Integer intCellValue, HorizontalAlignment halign, VerticalAlignment valign, Map<String, Object> properties) {
        Cell cell = row.createCell(column);
        cell.setCellValue(intCellValue);
        CellUtil.setAlignment(cell, halign);
        CellUtil.setVerticalAlignment(cell, valign);
        CellUtil.setCellStyleProperties(cell, properties);
    }
    private void createCell(Workbook wb, Row row, int column, Double doubleCellValue, HorizontalAlignment halign, VerticalAlignment valign,  Map<String, Object> properties) {
        Cell cell = row.createCell(column);
        cell.setCellValue(doubleCellValue);
        CellUtil.setAlignment(cell, halign);
        CellUtil.setVerticalAlignment(cell, valign);
        CellUtil.setCellStyleProperties(cell, properties);

    }

    private void createCellNotBorder(Workbook wb, Row row, int column, String stringCellValue, HorizontalAlignment halign, VerticalAlignment valign) {
        Cell cell = row.createCell(column);
        cell.setCellValue(stringCellValue);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }



}
