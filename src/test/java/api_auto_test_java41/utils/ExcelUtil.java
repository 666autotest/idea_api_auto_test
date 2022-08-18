package api_auto_test_java41.utils;


import api_auto_test_java41.pojo.CaseData;
import api_auto_test_java41.pojo.ExcelPojo;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

import java.io.File;
import java.util.List;

/**
 * @author qq音乐
 * @date 2022/7/22 - 0:52
 */
public class ExcelUtil {
    public static final String EXCEL_FILE_PATH="src\\test\\resources\\caseData.xlsx";

    /**
     * 读取外部Excel 工具的方法
     * * @sheetNum  sheetNum的索引，从0开始
     * @return 读取到的数据
     */
    public static List<ExcelPojo> readExcel(int sheetNum){
        //1.读取Excel-->导入Easypoi
        File file = new File("src\\test\\resources\\testcase.xlsx");
        //2.读取Excel的参数配置，默认会读取所有的内容
        ImportParams importParams = new ImportParams();
        //3.设置开始读取sheet的位置，0-->第一个sheet
        importParams.setStartSheetIndex(sheetNum);
        List<ExcelPojo> datas = ExcelImportUtil.importExcel(file, ExcelPojo.class,importParams);

/*      Object[] data = datas.toArray();
        return data;*/
        return datas;

        //easyPOi自动关流，这里不需要手动关流
    }


    }

