package api_auto_test_java41.domeArrayList;
/*数组元素反转
反转前：{10,20,30,40,50}
反转后：{50,40,30,20,10}*/
public class demoArray11 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        //变量输出数组
        for (int i = 0; i < array.length; i++) {
                //数组反转前
                System.out.println(array[i]);

        }
        /**
         * 采用倒手方式遍历
         * 初始化语句：int min = 0，max = array.length-1,min<max,min++,max--
         * 条件判断：min<max
         * 步进表达式：min++,max--
         * 循环体,用第三个变量接收
         */
        System.out.println("===================");
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }
        //在此遍历输出数组后来的样子
        for (int i = 0; i < array.length; i++) {
            //数组反转后
            System.out.println(array[i]);
        }
    }
}