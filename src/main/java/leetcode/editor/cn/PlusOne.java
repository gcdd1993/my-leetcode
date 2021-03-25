package leetcode.editor.cn;

/**
 * [66]加一 Created By gcdd1993 on 2021-03-25 16:03:06.
 * <p/>
 * 解题思路：
 * TODO
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            // 遇10进1，是要实现一个计算器？
            for (int i = digits.length - 1; i > -1; i--) { // 从末尾开始处理，将数字+1，如果结果大于10，则前一位需要加1
                int sum = digits[i] + 1;
                if (sum == 10) {
                    digits[i] = 0;
                    if (i == 0) {
                        // 已经到头，需要进位
                        int[] newInt = new int[digits.length + 1];
                        newInt[0] = 1;
                        // 复制数组到新数组
                        for (int j = 0; j < digits.length; j++) {
                            newInt[j + 1] = digits[j];
                        }
                        return newInt;
                    }
                } else {
                    digits[i] = sum;
                    break;
                }
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 650 👎 0
