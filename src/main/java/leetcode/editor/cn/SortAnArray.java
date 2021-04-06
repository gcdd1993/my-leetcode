package leetcode.editor.cn;

/**
 * [912]排序数组 Created By gcdd1993 on 2021-04-06 16:04:45.
 * <p/>
 * 解题思路：
 * TODO
 */
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();

        int[] res = solution.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            // 插入排序
//            int j;
//            for (int i = 1; i < nums.length; i++) {
//                int tmp = nums[i];
//                for (j = i; j > 0 && tmp < nums[j - 1]; j--) {
//                    nums[j] = nums[j - 1];
//                }
//                nums[j] = tmp;
//            }
//            return nums;
            // 快速排序
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (right - left <= 2) {
                return;
            }
            // 获取左、中、右较小值
            int pivot = median3(nums, left, right);
            System.out.println("pivot: " + pivot);
            int i = left, j = right - 1;
            for (; ; ) {
                while (nums[++i] < pivot) {
                }
                while (j > 0 && nums[--j] > pivot) {
                }
                if (i < j) {
                    swap(nums, i, j);
                } else {
                    break;
                }
            }

            swap(nums, i, right - 1);

            // 递归排左侧
            quickSort(nums, left, i - 1);
            // 递归排右侧
            quickSort(nums, i + 1, right);
        }

        // 三数中值分割法
        private int median3(int[] nums, int left, int right) {
            int center = (left + right) / 2;
            if (nums[center] < nums[left]) {
                swap(nums, left, center);
            }
            if (nums[right] < nums[left]) {
                swap(nums, left, right);
            }
            if (nums[right] < nums[center]) {
                swap(nums, center, right);
            }
            swap(nums, center, right - 1);
            return nums[right - 1];
        }

        // 交换数组索引
        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 264 👎 0
