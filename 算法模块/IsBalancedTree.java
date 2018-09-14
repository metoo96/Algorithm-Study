/**
*平衡二叉树的判定
*@author Guozhu Zhu
*@date 2018/9/15
*@version 1.0
*
*/
public class Solution {
    
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((Math.abs(getHeight(root.left)-getHeight(root.right))) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right)+1;
    }
    
}