package io.github.gcdd1993.interview.pacvue;

/**
 * a="abc"，求a的倒序字符串
 * <p>
 * Created by gcdd1993 on 2021/4/8.
 */
public class Question1 {

    public static void main(String[] args) {
        String a = "abc";
        char[] ac = a.toCharArray();
        char[] res = new char[a.length()];
        for (int i = ac.length - 1; i >= 0; i--) {
            res[ac.length - 1 - i] = ac[i];
        }
        System.out.println(new String(res));
    }
}
