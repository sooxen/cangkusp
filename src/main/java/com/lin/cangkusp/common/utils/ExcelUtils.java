package com.lin.cangkusp.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.util.List;

public class ExcelUtils {
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, List<List<String>> list){

        //创建HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        //创建一个Sheet，对应Excel中的Sheet
        HSSFSheet sheet=hssfWorkbook.createSheet(sheetName);

        //创建第0行，用于设置标题
        HSSFRow row=sheet.createRow(0);

        //设置单元格样式为：居中
        HSSFCellStyle style=hssfWorkbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        HSSFCell cell=null;

        //设置标题
        for (int i=0;i<title.length;i++){
            cell=row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //设置数据
        for (int i=0;i<list.size();i++){
            row=sheet.createRow(i+1);
            for (int j=0;j<list.get(0).size();j++){
                row.createCell(j).setCellValue(list.get(i).get(j));
            }
        }
        return hssfWorkbook;
    }
}
