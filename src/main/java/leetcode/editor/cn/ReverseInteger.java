package leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long n = 0;
            while (x != 0) {
                n = n * 10 + x % 10;
                x = x / 10;
            }
            return (int) n == n ? (int) n : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}