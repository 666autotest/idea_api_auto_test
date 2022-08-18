package api_auto_test_java41.day07;

import java.util.ArrayList;

/**
 * @author qq音乐
 * @date 2022/6/30 - 2:00
 */

//第一道作业题
public class ArrayListDemo {
    public static void main(String[] args) {
        //1.创建老师对象
        Teacher s1 = new Teacher("张三",25);
        Teacher s2 = new Teacher("李四",35);
        Teacher s3 = new Teacher("老王",19);
        Teacher s4 = new Teacher("赵六",29);

        //2.创建ArrayList集合对象存储s1，s2，s3，s4
        ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);

        //3.增强for循环打印所有老师对应的name和age属性
        for (Teacher teacher:arrayList){
            //System.out.println(teacher.getName());
            //System.out.println(teacher.getAge());
            System.out.println(teacher);
        }

        //4.请求出集合中的老师平均年龄。//count存储老师数量
        int count = 0;//sum存储老师总成绩
        int sum = 0;//sum存储老师总成绩
        for(Teacher teacher : arrayList) {
            sum+=teacher.getAge();
            count++;
        }
        int result = sum /count;
        System.out.println("老师平均年龄:" +result);
        //改进版
        int sumAge = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Teacher teacher = arrayList.get(i);
            sumAge +=teacher.getAge();
        }
        System.out.println(sumAge/arrayList.size());
    }

    }

