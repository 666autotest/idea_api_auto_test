package api_auto_test_java41.day08;

/**
 * @author qq音乐
 * @date 2022/7/2 - 17:40
 */
public class StudentClass {
    private String classname;

    public StudentClass(String classname) {
        this.classname = classname;
    }

    public StudentClass() {
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "classname='" + classname + '\'' +
                '}';
    }
}
