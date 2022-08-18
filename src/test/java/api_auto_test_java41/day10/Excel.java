package api_auto_test_java41.day10;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

import java.io.File;
import java.util.List;

/**
 * @author qq音乐
 * @date 2022/7/6 - 22:18
 *
 * 作业：.读取附件中的Excel文件，通过Java对象集合接收，并转成数组，最后循环遍历数组输出。
 */

public class Excel {
    public static void main(String[] args) throws Exception {
        //1.生成excel文件对应的file对象
        File file = new File("src\\test\\resources\\api_testcases_futureloan_v1.xls");

        //2.生成ImportParams对象
        ImportParams importparams = new ImportParams();
        //3.从第一个sheet开始
        importparams.setStartSheetIndex(0);
        //4.读取Excel数据
        List<ExcelDate> list = ExcelImportUtil.importExcel(file, ExcelDate.class, importparams);
        for (ExcelDate excelDate: list) {
            System.out.println(excelDate.getTitle());
        }
        //5.转成数组，最后循环遍历数组输出
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);

        }
    }
}


