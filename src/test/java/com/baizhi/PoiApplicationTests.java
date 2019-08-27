package com.baizhi;

import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiApplicationTests {

    @Test
    public void contextLoads() {
        //创建excle工作簿对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = workbook.createSheet("用户信息");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        String[] titleRow = {"编号", "姓名", "出生日期"};
        //创建单元格对象

        HSSFCell cell = null;
        for (int i = 0; i < titleRow.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
        }
        //处理日期格式
        //样式对象
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        //日期格式
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        //设置日期格式
        cellStyle.setDataFormat(dataFormat.getFormat("yyyy年MM月dd日"));
        //处理数据行

        for (int i = 1; i < 10; i++) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue("小白" + i);
            //设置出生年月格式
            cell = row.createCell(2);
            cell.setCellValue(new Date());
            cell.setCellStyle(cellStyle);
        }

        try {
            workbook.write(new FileOutputStream(new File("C:/a.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
