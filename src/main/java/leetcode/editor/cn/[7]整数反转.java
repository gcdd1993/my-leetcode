package leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2^31 <= x <= 2^31 - 1
// 
// Related Topics 数学


// 👍 2630 👎 0

/**
 * 思路：
 * 1、给定的整数范围-2^31 <= x <= 2^31 - 1
 * 2、每次加上取x除以10的余数，下次将结果 * 10 再次加上x 除以10的余数
 */


//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {
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
