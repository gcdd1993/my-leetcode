package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * [145]二叉树的后序遍历 Created By gcdd1993 on 2021-03-26 13:32:21.
 * <p/>
 * 解题思路：
 * 左 ---> 右 ---> 根
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            // fix NPE
            if (root == null) {
                return res;
            }
            // 如果左节点不为空，遍历返回左节点的值
            if (root.left != null) {
                res.addAll(postorderTraversal(root.left));
            }
            // 如果右节点不为空，遍历返回右节点的值
            if (root.right != null) {
                res.addAll(postorderTraversal(root.right));
            }
            // 加入当前根节点
            res.add(root.val);
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 550 👎 0
