package test.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class Environment {
    //设计一个环境变量结构 类似于postman的环境变量
    //加static可直接通过:类名.方法名直接访问，无序创建对象
    //集合需实例化才能使用
    public static Map<String, Object> EnvironmentMap = new HashMap<String, Object>();

    /**
     * 向环境变量中存储对应的键值
     *
     * @param varName
     * @param varValue
     */
    public static void saveToEnvironment(String varName, Object varValue) {
        Environment.EnvironmentMap.put(varName, varValue);
        //EnvironmentMap.put(varName, varValue);
    }

    /**
     * 向环境变量中取对应的值
     * @param varName
     * @param
     */
    public static Object getEnvironment(String varName) {
        return Environment.EnvironmentMap.get(varName);
    }

    /**
     * 字符串类型数据参数化替换
     * @param inputParam 接口入参
     * @return 参数化替换之后的结果
     */
    public static String replacParams(String inputParam) {
        //识别#XXX# 正则表达式
        String regex = "#(.+?)#";
        //编译得到pattern模糊对象
        Pattern pattern = Pattern.compile(regex);
        //通pattern的matcher匹配得到匹配器
        Matcher matcher = pattern.matcher(inputParam);
        //循环在原始的字符串中来找符合正则表达式对应的字符串
        while (matcher.find()) {
            //match.groud(0) 表示整个匹配到的字符串
            String wholeStr = matcher.group(0);
            //System.out.println(wholeStr);
            //System.out.println(matcher.group(0));
            //matcher.group(1),分组的第一个结果，#XX#里面的XX
            String subStr = matcher.group(1);
            //System.out.println(subStr);
            //替换#XXX#
            //+""意思是装换成字符串
            inputParam = inputParam.replace(wholeStr, Environment.getEnvironment(subStr) + "");
        }
        return inputParam;
    }

    /**
     * 字符串类型数据参数化替换
     * @param headersMap 请求头
     * @return 参数化替换之后的结果
     * 方法重载
     */
    public static Map replacParams(Map headersMap){
        //把Map转换为字符串
        String datas=JSONObject.toJSONString(headersMap);
        //识别#XXX# 正则表达式
        String regex = "#(.+?)#";
        //编译得到pattern模糊对象
        Pattern pattern = Pattern.compile(regex);
        //通pattern的matcher匹配得到匹配器
        Matcher matcher = pattern.matcher(datas);
        //循环在原始的字符串中来找符合正则表达式对应的字符串
        while (matcher.find()) {
            //match.groud(0) 表示整个匹配到的字符串
            String wholeStr = matcher.group(0);
            //System.out.println(wholeStr);
            //System.out.println(matcher.group(0));
            //matcher.group(1),分组的第一个结果，#XX#里面的XX
            String subStr = matcher.group(1);
            //System.out.println(subStr);
            //替换#XXX#
            //+""意思是装换成字符串
            datas = datas.replace(wholeStr,Environment.getEnvironment(subStr)+"");
        }
        //把字符串再转换成Map
        Map map=JSONObject.parseObject(datas);
        return map;
    }


    public static void main(String[] args) {
        String inputParam = "{\"basketId\":0,\"count\":1,\"prodId\":\"#prodId#\",\"shopId\":1,\"skuId\":\"#skuId#\"}";
        //#可换成&
        //{"basketId":0,"count":1,"prodId":"#prodId#","shopId":1,"skuId":"#skuId#"}
        //1.将对应的值保存到环境变量中
        Environment.saveToEnvironment("prodId",101);
        Environment.saveToEnvironment("skuId",203);
        //replaceParam 方法完成替换
        //System.out.println(replacParams(inputParam));


    }
}
