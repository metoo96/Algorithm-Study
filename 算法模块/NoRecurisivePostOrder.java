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
 * 二叉树的非递归
 * @author  Guozhu Zhu
 * @Date 2019/3/1
 * @version  1.0
 */
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode last = root;
        if (root == null) {
            return resList;
        }
        TreeNode temp;
        while (!stack.isEmpty()) {
            temp = stack.peek();
            if ((temp.left == null && temp.right == null) || (temp.right == null && last == temp.left) || last == temp.right) {
                resList.add(temp.val);
                last = temp;
                stack.pop();
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                } 
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
        }
        return resList;
    }
    
}