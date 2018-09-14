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
* 二叉树的前序遍历非递归实现
* @author Guozhu Zhu
* @date 2018/9/13
* @version 1.0
*/
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<Integer>();
       Stack<TreeNode> stack = new Stack<>();
       TreeNode temp = root;
       while (temp != null || !stack.isEmpty()) {
           while (temp != null) {
               stack.push(temp);
               list.add(temp.val);
               temp = temp.left;
           }
           temp = stack.peek();
           stack.pop();
           temp = temp.right;
       }
       return list;
    }
    
}