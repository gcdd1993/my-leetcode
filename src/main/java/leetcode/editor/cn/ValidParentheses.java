package leetcode.editor.cn;

// [20]有效的括号
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            int m = s.length() / 2;
            int y = s.length() % 2;
            if (y > 0) { // 长度不为2的整数倍，肯定不配对
                return false;
            }
            for (int i = 0; i < m; i++) {
                s = s
                        .replace("()", "")
                        .replace("[]", "")
                        .replace("{}", "")
                ;
            }
            return s.length() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}