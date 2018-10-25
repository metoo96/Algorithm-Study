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
* @author Guozhu Zhu
* @date 2018/10/25
* @version 1.0
*/
class Solution {
    
    public boolean hasPathSum(TreeNode root, int sum) {
         if (root == null)
            return false;
        return hasPathSumCore(root, 0, sum);
    }
     
    public boolean hasPathSumCore(TreeNode root, int sum, int target) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && target == sum+root.val)
            return true;
        if (root.left == null && root.right == null)
            return false;
        return hasPathSumCore(root.left, sum+root.val, target) || hasPathSumCore(root.right, sum+root.val, target);
    }
    
}
