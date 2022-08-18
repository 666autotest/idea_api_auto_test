package api_auto_test_java41.domeArrayList;

public class Person {
    private String name;
    private int age;

    //1.无参构造
    public Person() {
    }

    //2.有参构造
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}
