package day01;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;

    }
    public int getAge(){
        return age;
    }
    public void setAge(){
        this.age=age;
    }
}