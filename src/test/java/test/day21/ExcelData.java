
package test.day21;

import cn.afterturn.easypoi.excel.annotation.Excel;


/**
 * @author luxi
 * @date 2021/10/25 0:39
 * 说明：Excel映射实体类
 */

public class ExcelData {
    //通过Excel注解将Excel中的数据映射进来
    @Excel(name = "name")
    private String name;

    @Excel(name = "phone")
    private String phone;

    @Excel(name = "password")
    private String password;

    public ExcelData(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ExcelData() {
    }

    @Override
    public String toString() {
        return "ExcelData{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

