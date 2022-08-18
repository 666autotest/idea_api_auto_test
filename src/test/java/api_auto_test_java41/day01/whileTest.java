package api_auto_test_java41.day01;

/**
 * @author qq音乐
 * @date 2022/7/25 - 2:27
 */
public class whileTest {
    public static void main(String[] args) {
        /**
         * 初始化语句 1
         * while(循环条件 2){
         *     循环体 3
         *     迭代语句 4
         * }
         */
        int i= 1;
        while(i<10){
            System.out.println(i);
            i++;
        }
        //do……while……
        int j = 11;
        do {
            System.out.println(j);//输出11,先执行，在判断循环条件
            j++;
        }while (j<=10);


/*        while(true){
            System.out.println("死循环");
            if(1==1){
                break;
            }
        }*/
    }

}

//do…while…：先执行循环体，然后在判断循环条件，如果循环条件为真，进行下一次循环，否则终止循环。因此循环体里的代码至少执行一次，因为不管条件满不满足，它是先执行再判断条件
//while：先判断循环条件，条件为真才执行循环体*/
