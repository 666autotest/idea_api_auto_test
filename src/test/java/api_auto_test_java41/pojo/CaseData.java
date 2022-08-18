package api_auto_test_java41.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author qq音乐
 * @date 2022/7/17 - 22:43
 */
public class CaseData {
    @Excel(name = "用例编号")
    private int caseId;
    @Excel(name = "用例标题")
    private String caseTitle;
    @Excel(name = "接口入参")
    private String importParams;
    @Excel(name = "响应断言")
    private String responseAssert;

    public CaseData(int caseId, String caseTitle, String importParams, String responseAssert) {
        this.caseId = caseId;
        this.caseTitle = caseTitle;
        this.importParams = importParams;
        this.responseAssert = responseAssert;
    }

    public CaseData() {
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getImportParams() {
        return importParams;
    }

    public void setImportParams(String importParams) {
        this.importParams = importParams;
    }

    public String getResponseAssert() {
        return responseAssert;
    }

    public void setResponseAssert(String responseAssert) {
        this.responseAssert = responseAssert;
    }

    @Override
    public String toString() {
        return "CaseData{" +
                "caseId=" + caseId +
                ", caseTitle='" + caseTitle + '\'' +
                ", importParams='" + importParams + '\'' +
                ", responseAssert='" + responseAssert + '\'' +
                '}';
    }
}

