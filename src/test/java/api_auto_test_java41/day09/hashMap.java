package api_auto_test_java41.day09;

public class hashMap {
    private String name;
    private Integer age;

    public hashMap() {
    }

    public hashMap(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Map{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
