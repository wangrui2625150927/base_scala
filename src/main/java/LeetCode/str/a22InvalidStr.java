package main.java.LeetCode.str;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.Stack;

/**
 * @ClassName a22InvalidStr
 * @Description
 * @Author WangRui
 * @Date 2020/8/14 11:12
 */
public class a22InvalidStr {
    public static void main(String[] args) {
        System.out.println(isValidAll("({){})"));
        System.out.println(isValidAll("(){}"));
        System.out.println(isValidAll("({}){}"));
    }

    //只适合前后括号一致的情况({}),对于这样的(){}[]无法解决
    public static boolean isValid(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        //长度不是偶数，直接返回false；
        if (n % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n / 2; i++) {
            String w = a[i] + "" + a[n - 1 - i];
            System.out.println(w);
            if (w.equals("()") || w.equals("[]") || w.equals("{}")) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    public static boolean isValidAll(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        //用栈来进行对立括号的存储
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        //列如最后一个元素是{,虽然栈内加入进去了，但是没有机会出栈，所以为false;
        return false;

    }
}
