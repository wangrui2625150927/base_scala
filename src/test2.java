import javax.xml.transform.Source;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s= sc.next().substring(0,n-1);
        System.out.println(s);

        System.out.println(getLongs(s));

    }
    /*
         * 返回连续单个字符出现最多次数的字符和个数
         */
        public static String  getLongs(String s)
        {
            Pattern pattern = Pattern.compile("([a-zA-Z])\\1+");
            Matcher matcher = pattern.matcher(s);
            String word = "";
            while (matcher.find())
            {
                String index = matcher.group();
                if (word.length() < index.length())
                {
                    word = index;
                }
            }

            return word.substring(0,word.length()-1)+word.length();
        }



}
