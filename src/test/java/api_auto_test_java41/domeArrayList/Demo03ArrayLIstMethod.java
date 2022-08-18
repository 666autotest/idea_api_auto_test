package api_auto_test_java41.domeArrayList;

import java.util.ArrayList;

/**
 * ArrayList常用方法有：
 * pbulic boolean add(E e):向集合当中添加元素，参数类型和泛型一致
 * 备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值可用可不用；
 * 但是对于其他集合来说。add添加动作不一定成功。
 *
 *
 * pbulic E get(int index):向集合当中获取元素，参数是索引编号，返回值就是对应的位置的元素
 * pbulic E remove(int remove):向集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素
 * pbulic int size():获取集合长度，返回值就是集合当中包含的元素个数
 *
 */
public class Demo03ArrayLIstMethod {
    public static void main(String[] args) {

        //1.创建数组
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);// 输出：[]

        //2.向集合当中添加元素，add

        boolean success = list.add("柳岩");
        System.out.println(list);//柳岩
        System.out.println("添加动作是否成功："+success);//true

        list.add("高圆圆");
        list.add("赵又延");
        list.add("李小璐");
        list.add("贾乃亮");
        list.add("贾乃亮");
        System.out.println(list);//高圆圆 赵又延 李小璐 贾乃亮

        //3.从集合中获取元素，get(0),索引从0开始
        String name = list.get(2);
        System.out.println("第二个索引位置："+name);
        System.out.println("第二个索引位置："+list.get(2));
        //4.从集合当中删除元素
        String whoRemove = list.remove(3);
        System.out.println("被删掉的人是："+whoRemove);
        System.out.println(list);//高圆圆 赵又延 贾乃亮

        //5.获取集合长度，也就是集合当中元素的个数
        int size = list.size();
        System.out.println("集合的长度是："+size);

        //6.遍历数组：[柳岩, 高圆圆, 赵又延, 贾乃亮]
        for (int i = 0; i < list.size(); i++) {//快捷键:list.fori
            System.out.println(list.get(i));
        }
    }
}
