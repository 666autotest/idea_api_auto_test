package api_auto_test_java41.data;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qq音乐
 * @date 2022/7/18 - 1:00
 * 备注：这里类废弃，用test目录下单BaseTest
 */
public class Environment {
    //设定义一个map数据结构的环境变量,加static方便全局访问
    public static Map<String, Object> var = new HashMap<String, Object>();

    /**
     * 向环境变量中存储对应的值
     *
     * @param varName
     * @return
     */
    public static void saveToEnvironment(String varName, Object varValue) {
        Environment.var.put(varName, varValue);

    }

    /**
     * 从环境变量中取得对应的值
     * @param varName
     * @return
     */
    public static Object getFromEnvironment(String varName) {
        return Environment.var.get(varName);
    }

    /**
     * 字符串类型数据参数化替换
     * @param inputParam 接口入参
     * @return 参数化替换之后的结果
     */
    //定义一个正则表达式的方法
    public static String replaceParams(String inputParam) {
        //识别#XXX#,正则表达式
        String regex = "#(.+?)#";
        //编译得到Pattern模式对象
        Pattern pattern = Pattern.compile(regex);
        //3.通过Pattern的matcher匹配，得到匹配-->搜索
        Matcher matcher = pattern.matcher(inputParam);
        //循环在原始的字符串中来找符合正则表达式对应的字符串
        while (matcher.find()) {
            //matcher.group(0) 表示整个匹配到的字符串
            String wholeStr = matcher.group(0);
            //matcher.group(1) 分组的第一个结果，#XXX#里的XXX
            String subStr = matcher.group(1);
            //替换#XXX#
            inputParam = inputParam.replace(wholeStr, Environment.getFromEnvironment(subStr)+"");
        }
        return inputParam;
    }

    /**
     * headMap类型数据参数化替换
     * @param headerMap 接口入参
     * @return 参数化替换之后的结果
     */
    //APiCall,headersMap参数化需要用到
    public static Map replaceParams(Map headerMap) {
        //1.把Map转成字符串
        String datas = JSONObject.toJSONString(headerMap);

/*        //2.识别#XXX#,正则表达式
        String regex = "#(.+?)#";
        //编译得到Pattern模式对象
        Pattern pattern = Pattern.compile(regex);
        //3.通过Pattern的matcher匹配，得到匹配-->搜索
        Matcher matcher = pattern.matcher(datas);
        //4.循环在原始的字符串中来找符合正则表达式对应的字符串
        while (matcher.find()) {
            //matcher.group(0) 表示整个匹配到的字符串
            String wholeStr = matcher.group(0);
            //matcher.group(1) 分组的第一个结果，#XXX#里的XXX
            String subStr = matcher.group(1);
            //5.替换#XXX#
            datas = datas.replace(wholeStr, Environment.getFromEnvironment(subStr)+"");
        }*/

        datas = replaceParams(datas);
        //6.把字符串转成Map
        Map map = JSONObject.parseObject(datas);
        return map;

    }



    public static void main(String[] args) {
/*
        String inputParam = "{\"basketId:0,\"count\":1,\"prodId\":#prodId#,\"shopid\":1,\"skuId\":#skuId#}";
        //{"basketId:0,"count":1,"prodId":83,"shopid":1,"skuId":415}
*/
/*        int prodId = 83;
        int skuId = 415;*//*

        //将要替换的值保存到环境变量中
        Environment.saveToEnvironment("prodId",83);
        Environment.saveToEnvironment("skuId",415);
        //2.replaceParams完成替换

        System.out.println(replaceParams(inputParam));
*/

    }
}