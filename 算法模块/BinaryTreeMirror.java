/**
public class TreeNode {
	
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
*/
/**
* 二叉树的镜像问题
* @author Guozhu Zhu
* @date 2018/8/10
* @version 1.0
*
*/
public class Solution {
	
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        //交换左右孩子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
	
}
