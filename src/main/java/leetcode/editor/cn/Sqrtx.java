package leetcode.editor.cn;

/**
 * [69]x 的平方根 Created By gcdd1993 on 2021-03-27 12:31:14.
 * <p/>
 * 解题思路：
 * 二分查找，下界为0，上界为x
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();

//        System.out.println(solution.mySqrt(1));
//        System.out.println(solution.mySqrt(2));
//        System.out.println(solution.mySqrt(4));
//        System.out.println(solution.mySqrt(6));
//        System.out.println(solution.mySqrt(8));
//        System.out.println(solution.mySqrt(16));
        System.out.println(solution.mySqrt(2147395599));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            //
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                // 不转long，可能为到达int的最大值，从而被转为负值，例如1073697799 * 1073697799 = -209283023
//                System.out.println(mid + " * " + mid + " = " + mid * mid);
                if ((long) mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 631 👎 0
