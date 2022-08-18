package api_auto_test_java41.domeArrayList;

import java.util.ArrayList;

/**
 * 如果希望想集合ArrayList当中存储基本数据类型数据，必须使用基本数据类型对应的"包装类"
 *
 * 基本数据类型    包装类(引用类型，包装类都位于java.lang包下，所以不需要导包)
 * byte         Byte
 * short        Short
 * long         Long
 * int          Integer
 * float        Float
 * double       Double
 * char         Charactor
 * boolean      Boolean
 *
 * 从jdk1.5+开始，支持自动装箱、拆箱
 * 装箱：基本数据类型 -->包装类型
 * 拆箱：包装类型 -->基本数据类型
 *
 * */

public class Demo04ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();

        //错误写法！泛型只能是引用类型，不能是基本数据类型
        //ArrayList<int> listB = new ArrayList<>();

        ArrayList<Integer> listC = new ArrayList<>();
        listC.add(100);
        listC.add(200);
        System.out.println(listC);

        int num = listC.get(1);
        System.out.println("第1号元素是，："+num);


    }

 }
