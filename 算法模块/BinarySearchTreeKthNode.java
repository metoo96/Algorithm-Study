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
/**
* 二叉搜索树, 第k小的节点
* @author Guozhu Zhu
* @date 2018/8/10
* @version 1.0
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
