package api_auto_test_java41.day10;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import test.day21.ExcelData;

import java.io.File;
import java.util.List;

/**
 * @author qq音乐
 * @date 2022/7/16 - 0:21
 */
public class Test {
    public static void main(String[] args) {
        //1.创建文件对象
        File file = new File("src");
        //2.导入importparams对象
        ImportParams importParams = new ImportParams();
        //3.设置读取那个sheet
        importParams.setStartSheetIndex(0);
        //4.读取Excel参数
        List<ExcelData> list = ExcelImportUtil.importExcel(file,ExcelData.class,importParams);
        for (ExcelData excelData:list
             ) {
            System.out.println(excelData.getName());

        }
         //5.转成数组，最后循环遍历输出
        Object[] data = list.toArray();
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);

        }
    }
}
