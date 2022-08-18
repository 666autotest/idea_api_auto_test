package api_auto_test_java41.day09;

/**
 * @author qq音乐
 * @date 2022/7/2 - 15:50
 */
public class Provinces1
{
    private String name;

    private String capital;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCapital(String capital){
        this.capital = capital;
    }
    public String getCapital(){
        return this.capital;
    }

    @Override
    public String toString() {
        return "Provinces{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}