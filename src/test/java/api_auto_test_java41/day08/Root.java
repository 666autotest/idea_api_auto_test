package api_auto_test_java41.day08;
import java.util.List;

/**
 * @author qq音乐
 * @date 2022/7/2 - 17:07
 */


public class Root
{
    private String name;

    private List<Provinces> provinces;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setProvinces(List<Provinces> provinces){
        this.provinces = provinces;
    }
    public List<Provinces> getProvinces(){
        return this.provinces;
    }
}
