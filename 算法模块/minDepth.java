/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * @author  Guozhu Zhu]
 * @date  2019/9/19
 * @version  1.0
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null)
            return minDepth(root.right) + 1;  
        if(root.right == null)
            return minDepth(root.left) + 1;  
          
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;  
    }
}