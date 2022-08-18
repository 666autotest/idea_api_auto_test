package api_auto_test_java41.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ExcelPojo {
    @Excel(name = "序号")
    private int caseId;
    @Excel(name = "用例标题")
    private String title;
    @Excel(name = "请求头")
    private String headers;
    @Excel(name = "请求方式")
    private String method;
    @Excel(name = "接口地址")
    private String url;
    @Excel(name = "参数输入")
    private String params;
    @Excel(name = "期望返回结果")
    private String expectedValue;
    @Excel(name = "提取响应字段")
    private String extractField;
    @Excel(name = "数据库结果")
    private String expectedDB;

    public ExcelPojo() {
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getExtractField() {
        return extractField;
    }

    public void setExtractField(String extractField) {
        this.extractField = extractField;
    }

    public String getExpectedDB() {
        return expectedDB;
    }

    public void setExpectedDB(String expectedDB) {
        this.expectedDB = expectedDB;
    }

    @Override
    public String toString() {
        return "ExcelPojo{" +
                "caseId=" + caseId +
                ", title='" + title + '\'' +
                ", headers='" + headers + '\'' +
                ", method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", params='" + params + '\'' +
                ", expectedValue='" + expectedValue + '\'' +
                ", extractField='" + extractField + '\'' +
                ", expectedDB='" + expectedDB + '\'' +
                '}';
    }
}
