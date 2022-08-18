package api_auto_test_java41.domeArrayList;
import java.util.ArrayList;

/**
 * 题目
 * 1.自定义student学生类
 * 2.一个集合，用来存储学生对象，泛型<student>
 * 3.根据类，创建4个学生对象
 * 4.将4个学生对象添加到集合中，add
 * 5.遍历集合，for、size、get
 *
 */
public class Demo06ArrayListStudent {
    public static void main(String[] args) {

    //1.定义student学生类
    //2.创建集合
    ArrayList<Student> list = new ArrayList<>();

    //3.创建学生对象并赋值
    Student one = new Student("洪七公",20);
    Student two = new Student("欧阳锋",21);
    Student three = new Student("黄药师",22);
    Student four = new Student("杨过",23);

    //4.添加学生对象到集合中
    list.add(one);
    list.add(two);
    list.add(three);
    list.add(four);

    //遍历集合
     for (int i = 0; i < list.size(); i++) {
           Student stu = list.get(i);
         System.out.println("姓名："+stu.getName()+",年龄:"+stu.getAge());
         System.out.println(stu.getAge());//得到所有的年龄

     }
    }
}