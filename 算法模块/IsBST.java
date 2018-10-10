import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
/**
* @author Guozhu Zhu
* @date 2018/10/10
* @version 1.0
*/
public class Checker {
    
    public boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode p = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        int temp = Integer.MIN_VALUE;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            } 
            if (!s.isEmpty()) {
                p = s.pop();
                if (p.val <= temp) {
                    return false;
                }
                temp = p.val;
                p = p.right;
            }
        }
        return true;
    }
    
}
