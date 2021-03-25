package leetcode.editor.cn;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            int b = x;
            if (x < 0) {
                return false;
            }
            if (x == 0) {
                return true;
            }
            if (x % 10 == 0) {
                return false;
            }
            long n = 0;
            while (x != 0) {
                n = n * 10 + x % 10;
                x = x / 10;
            }
            return n - b == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}