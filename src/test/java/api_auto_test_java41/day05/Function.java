package api_auto_test_java41.day05;

/**
* @author qq音乐
 * @date 2022/6/24 - 23:24
*/
//第一道作业
//1班，2班，3班的这次考试分数分别为：

public class Function {
    public void scorePass(int []classX){
        int sum = 0;
        for (int i = 0; i < classX.length; i++) {
            int score = classX[i];
            if(score >=60){
                sum++;
            }

            System.out.println("及格人数:"+ sum);
        }
    }

      }

