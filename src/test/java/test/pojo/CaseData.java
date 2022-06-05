package test.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class CaseData {
    //引入Excel注解
    @Excel(name = "用例编号")
    private int caseid;

    @Excel(name = "用例标题")
    private String caseTitle;

    @Excel(name = "接口入参")
    private String inputParams;

    @Excel(name = "响应断言")
    private String assertResponse;

    @Excel(name="数据库断言")
    private String assertDB;

    public CaseData(int caseid, String caseTitle, String inputParams, String assertResponse, String assertDB) {
        this.caseid = caseid;
        this.caseTitle = caseTitle;
        this.inputParams = inputParams;
        this.assertResponse = assertResponse;
        this.assertDB = assertDB;
    }

    public CaseData() {
    }

    public int getCaseid() {
        return caseid;
    }

    public void setCaseid(int caseid) {
        this.caseid = caseid;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams;
    }

    public String getAssertResponse() {
        return assertResponse;
    }

    public void setAssertResponse(String assertResponse) {
        this.assertResponse = assertResponse;
    }

    public String getAssertDB() {
        return assertDB;
    }

    public void setAssertDB(String assertDB) {
        this.assertDB = assertDB;
    }

    @Override
    public String toString() {
        return "CaseData{" +
                "caseid=" + caseid +
                ", caseTitle='" + caseTitle + '\'' +
                ", inputParams='" + inputParams + '\'' +
                ", assertResponse='" + assertResponse + '\'' +
                ", assertDB='" + assertDB + '\'' +
                '}';
    }
}
