/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  
     public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode root, Integer max, Integer min){
        if(root == null){
            return true;
        }
        // 如果该节点大于上限 返回假
        if(max != null && root.val >= max){
            return false;
        }
        // 如果该节点小于下限 返回假
        if(min != null && root.val <= min){
            return false;
        }
        // 递归判断左子树和右子树
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }
    
}