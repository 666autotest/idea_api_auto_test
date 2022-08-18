package api_auto_test_java41.domeArrayList;

/**
 数组：它是一个容器，用来存放数据，不同类型的数组可以盛放不同类型的数据。
 特点：
 1.数组是一种引用类型。
 2.固定长度：数组长度在程序运行期间不可改变。
 3.固定数据类型：数组中的数据，类型必须统一。
 4.缺点：数组一旦创建，程序运行期间长度不可改变，所以出现了ArrayList集合
 创建数组方式：
 1.静态初始化：创建数组的同时对内部元素初始化,即赋值
 数据类型[] 数组名 = {值1,值2,值3,值4};如：int[] array = {1,2,3,4};
 2.动态初始化:先定义数组长度在赋值
 int [] a = new int [n];
 a[0] = 1;
 a[1] = 5;

 3.数组元素通过，索引访问
 4.数组长度通过，length()获取
 5.
 练习题：定义一个数组，用来存储3个person类.
 */
public class Demo01Array {
    public static void main(String[] args) {


/*        int[] arr = {1,2,3};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }*/

        //1.先创建一个长度为3的数组，里面用来存放peoson类型对象
        Person[] array = new Person [3];
        System.out.println(array);//地址值

        //2.创建对象并赋值
        Person one = new Person("迪丽热巴",18);
        Person two = new Person("古力娜扎",28);
        Person three = new Person("马尔扎哈",38);

        //3.将one中的地址值赋值到数组0元素位置,
        // 即给Person数组中的元素赋值-->初始化,否则array[1].getName()报错空指针：java.lang.NullPointerException
        array[0] = one;
        array[1] = two;
        array[2] = three;
        System.out.println(array[0]);//地址值
        System.out.println(array[1]);//地址值
        System.out.println(array[2]);//地址值

        //Person person =array[1];
        System.out.println(array[0].getName());//古力娜扎
        System.out.println(array[1].getName());
        System.out.println(array[2].getName());
    }
}
