package api_auto_test_java41.day08;

/**
 * @author qq音乐
 * @date 2022/7/2 - 2:42
 */
public class JsonInfo {
    private String name;
    private String capital;

    public JsonInfo(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public JsonInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
