package test.JDBCutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class regex {
    public static void main(String[] args) {
        String orginal="djsodjaldjl{{token}}dadljald{{token}}";
        String replacestr="123";
        String result=orginal;
        Pattern compile = Pattern.compile("\\{\\{(.*?)}}");
        Matcher matcher = compile.matcher(orginal);
        while (matcher.find()){
            String outstr = matcher.group(0);
            String innerstr = matcher.group(1);
            result=orginal.replace(outstr,replacestr);



        }
        System.out.println(result);


    }
}
