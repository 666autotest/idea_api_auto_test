package api_auto_test_java41.day08;


import java.util.*;
import java.util.Map.Entry;

/**
 * @author qq音乐
 * @date 2022/7/2 - 16:28
 */

public class HashMapHomeWork {
    public static void main(String[] args) {
        //作业第一题
        //1.实例化5个学生对象
        Student studentA = new Student("张三", 25, "男");
        Student studentB = new Student("李四", 26, "男");
        Student studentC = new Student("小花", 27, "女");
        Student studentD = new Student("小明", 28, "男");
        Student studentE = new Student("小红", 29, "女");

        //2.实例化2个班级
        StudentClass studentClass1 = new StudentClass("1801");
        StudentClass studentClass2 = new StudentClass("1802");

        //3.用数组存储value
        Student[] stutClass1 = {studentA,studentB,studentC};
        Student[] stuClass2 = {studentD,studentE};


        //实例化Hashmap
        HashMap<StudentClass, List<Student>> hashMap = new HashMap<>();

        //4.插入学生数据
        hashMap.put(studentClass1, Arrays.asList(stutClass1));
        hashMap.put(studentClass2, Arrays.asList(stuClass2));

        //5.遍历输出学生信息
        for (Entry<StudentClass, List<Student>> keyValue : hashMap.entrySet()) {

            System.out.println(keyValue.getKey());
            System.out.println(keyValue.getValue());
        }

    }
}


