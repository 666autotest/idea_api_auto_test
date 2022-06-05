///*
//
//
//package test.day21;
//
//import cn.afterturn.easypoi.excel.ExcelExportUtil;
//import cn.afterturn.easypoi.excel.ExcelImportUtil;
//import cn.afterturn.easypoi.excel.entity.ExportParams;
//import cn.afterturn.easypoi.excel.entity.ImportParams;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.io.File;
//
//*/
///**
// * @author luxi
// * @date 2021/10/25 0:39
// * /
//public class ExcelTest {
//    public static void main(String[] args) throws IOException {
//       //===================读取excel里的数据========================
//        //1.生存Excel文件对应的file对象
//        File file = new File("src\\test\\resources\\test.xlsx");
//        //2.生成ImportParams读取配置对象
//        ImportParams importParams = new ImportParams();
//        //3.设置读取第几个页签（0代表第1个页签）
//        importParams.setStartSheetIndex(1);
//        //4.设置读取第几行（0代表第1行数据，不包含标题在内 ）
//        importParams.setStartRows(0);
//        //5.setReadRows 总共读取第几行
//        importParams.setReadRows(2);
//        //6.读取出来的数据有多行，对应的返回结果并不是实体类对象，而是集合
//        List<ExcelData> allDates = ExcelImportUtil.importExcel(file,ExcelData.class,importParams);
//        System.out.println(allDates);
///*        //========================到处数据到Excel==================
//        //1.生成ExportParam到处配置对象
//        ExportParams exportParams = new ExportParams();
//        exportParams.setSheetName("登录测试用例");
//        //2.添加数据
//       ArrayList<ExcelData> list = new ArrayList<ExcelData>();
//        ExcelData excelData = new ExcelData("张三","13612957126","12345678");
//        list.add(excelData);* /
//
//
///*        //2-1简写模式
//       ArrayList<ExcelData> list =  new ArrayList<ExcelData>();
//       list.add(new ExcelData("罗杰","13612957126","12345678"));
//        list.add(new ExcelData("雷利","13612957127","12345678"));
//        list.add(new ExcelData("乌索普","13612957128","12345678"));
//        list.add(new ExcelData("乔巴","13612957128","12345678"));
//
//        //3.导出为工作簿对象
//        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,ExcelData.class,list);
//
//        //4.导出到真实的Excel文件中
//
//       /*File file = new File("output.xlsx");
//       OutputStream outputStream = new FileOutputStream(file);
//       workbook.write(outputStream);* /
//
//       workbook.write(new FileOutputStream(new File("exportdata.xls")));
//
//
//    }
//}
//
//
//
//
