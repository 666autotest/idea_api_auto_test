package api_auto_test_java41.day11;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import api_auto_test_java41.day10.ExcelDate;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static cn.afterturn.easypoi.excel.ExcelImportUtil.importExcel;

/**
 * @author qq音乐
 * @date 2022/7/8 - 22:11
 */
//2、基于上一题，请在RegisterTest测试类中实现读取附件中Excel文件的数据，编写测试方法实现数据驱动。
public class RegisterTest {
    @BeforeTest
    public void setupTest(){
        System.out.println("全局初始化操作");
    }

    @Test(dataProvider = "getRegisterDatas")
    public void register(ExcelDate excelDate){
        System.out.println(excelDate);
    }

    @DataProvider
    public Object[] getRegisterDatas(){
        File file = new File("src\\test\\resources\\api_testcases_futureloan_v1.xls");
        ImportParams importParams = new ImportParams();
        List<ExcelDate> list = ExcelImportUtil.importExcel(file, ExcelDate.class,importParams);
        Object[] datas = list.toArray();
        return datas;
    }
}
