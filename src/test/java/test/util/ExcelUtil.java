package test.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import test.pojo.CaseData;

import java.io.File;
import java.util.List;
public class ExcelUtil {
    public static final String EXCEL_FILE_path = "src\\test\\resources\\caseData.xlsx";

    /**
     * 读取外部Excel文件中的数据
     * @param sheetNum sheet的编号(从0开始)
     * return 读取到的数据
     */
    public static List<CaseData> readExcel(int sheetNum){
        //1、读取Excel-->通过Easypoi(导入依赖)
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(sheetNum);
        //Excel路径：src\test\resources\caseData.xlsx
        //读取Excel需要创建pojo实体类
        //通过集合接收数据
        List<CaseData> datas = ExcelImportUtil.importExcel(new File(EXCEL_FILE_path), CaseData.class,importParams);
        //集合转为数组
        return datas;
        //注入数据，指定数据源等于方法名：dataProvider = "getLoginDatasfromExcel"
    }
    }

