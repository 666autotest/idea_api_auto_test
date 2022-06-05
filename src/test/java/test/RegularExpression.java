package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 * z正则表达式：匹配搜索对应的字符串
 */
public class RegularExpression {
    public static void main(String[] args) {
    String inputParam="{\"basketId\":0,\"count\":1,\"prodId\":101,\"shopId\":1,\"skuId\":203}";
    int prodId = 101;
    int skuId = 203;
    //识别#XXX# 正则表达式
    String regex = "#.+?#";
    //编译得到pattern模糊对象
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(inputParam);
    //通pattern的matcher匹配得到匹配器
    while(matcher.find()){
        //match.groud(0) 表示整个匹配到的字符串
        System.out.println(matcher.group(0));
    }
    }
}
