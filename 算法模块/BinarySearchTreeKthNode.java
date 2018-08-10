import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {

    int count = 0;
    
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        TreeNode leftNode = KthNode(pRoot.left, k);
        if (leftNode != null) {
            return leftNode;
        }
        if (++count == k) {
            return pRoot;
        }
        TreeNode rightNode = KthNode(pRoot.right, k);
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }

}