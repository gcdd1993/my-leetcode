package io.github.gcdd1993.interview.pacvue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * String[] a, String[] b，求两个字符串数组的交集，注意效率
 * <p>
 * Created by gcdd1993 on 2021/4/8.
 */
public class Question2 {

    public static void main(String[] args) {
        String[] a = new String[]{"abc", "def", "ghi", "jkm"};
        String[] b = new String[]{"abcd", "defe", "ghisd", "jkmds", "dsa", "abc", "def"};

        int length = Math.min(a.length, b.length);
        String[] res = new String[length];
        int index = 0;
        // O(mn)
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < b.length; j++) {
                if (a[i].equals(b[j])) {
                    res[index++] = a[i];
                }
            }
        }
        System.out.println(Arrays.toString(res));

        // O(m + n)，将其中一个数组转成hash表
        index = 0;
        Set<String> aSet = new HashSet<>(Arrays.asList(a));
        for (int i = 0; i < b.length; i++) {
            if (aSet.contains(b[i])) {
                res[index++] = b[i];
            }
        }
        System.out.println(Arrays.toString(res));

        // O(m + n)，排序 + 双指针，在有序的情况下，可以使用双指针
        Arrays.sort(a);
        Arrays.sort(b);
        int length1 = a.length;
        int length2 = b.length;
        res = new String[length1 + length2];
        index = 0;
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            // 如果相等
            if (a[index1].equals(b[index2])) {
                // 去重
                if (index == 0 || !res[index - 1].equals(a[index1])) {
                    res[index++] = a[index1];
                }
                index1++;
                index2++;
            } else if (a[index1].compareTo(b[index2]) < 0) {
                index1++;
            } else {
                index2++;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
