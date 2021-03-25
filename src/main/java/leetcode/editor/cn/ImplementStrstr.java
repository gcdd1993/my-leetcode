package leetcode.editor.cn;

import java.util.Objects;

/**
 * [28]实现 strStr() Created By gcdd1993 on 2021-03-25 14:32:58.
 * <p/>
 * 解题思路：
 * TODO
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();

        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            // 当 needle 是空字符串时我们应当返回 0
            if (needle.length() == 0) {
                return 0;
            }
            if (!haystack.contains(needle)) {
                return -1;
            }
            // 遍历haystack 长度 - needle 长度次数，直到截取的子字符串与needle相等，当前的index即为所求的index
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                String sub = haystack.substring(i, i + needle.length()); // 每次截取needle长度的子字符串进行比较
                System.out.println(sub);
                if (Objects.equals(sub, needle)) {
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 757 👎 0
