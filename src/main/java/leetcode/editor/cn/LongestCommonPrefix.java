package leetcode.editor.cn;

// [14]最长公共前缀
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // 暴力解法，从头往后一个个判断
//        if (strs.length == 0) {
//            return "";
//        }
//        if (strs.length == 1) {
//            return strs[0];
//        }
//        String p = "";
//        int index = 0;
//        for (; ; ) {
//            if (index >= strs[0].length()) {
//                return p;
//            }
//            char c = strs[0].charAt(index);
//            for (int i = 1; i < strs.length; i++) {
//                if (index >= strs[i].length()) {
//                    return p;
//                }
//                if (strs[i].charAt(index) != c) {
//                    return p;
//                }
//            }
//            p += c;
//            index++;
//        }
            // 先找出前两个的公共前缀，将其作为新字符串，与后一个比对，直至最后一个
            if (strs.length == 0) {
                return "";
            }
            int index = 0;
            String p = strs[index]; // 2
            while (index < strs.length - 1 && p.length() > 0) {
                String s = strs[index + 1]; // 0 1
                String p1 = "";
                for (int i = 0; i < p.length(); i++) {
                    if (s.length() <= i) {
                        break;
                    }
                    if (p.charAt(i) == s.charAt(i)) {
                        p1 += p.charAt(i);
                    } else {
                        break;
                    }
                }
                p = p1;
                index++;
            }
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}