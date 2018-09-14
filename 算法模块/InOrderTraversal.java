package p38;

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
 * 中序遍历二叉树非递归实现
 * @author Guozhu Zhu
 * @date 2018/9/13
 * @version 1.0
 */
class Solution {
   
    public List<Integer> inorderTraversal(TreeNode root) {
      ArrayList<Integer> res = new ArrayList<Integer>();
       Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
      while(temp != null || !stack.isEmpty()) {
        while(temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        if(!stack.isEmpty()) {
            temp = stack.peek();
            res.add(temp.val);
            stack.pop();
            temp = temp.right;
        }
      }
        return res;
    }

}
