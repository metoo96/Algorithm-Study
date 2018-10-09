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
* BST的第k个小的元素
* @author Guozhu Zhu
* @date 2018/10/09
* @version 1.0
*/
class Solution {

    public int kthSmallest(TreeNode pRoot, int k) {
       if (pRoot == null || k <= 0) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        TreeNode p = pRoot;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (++count == k) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return 0;
    }
    
}
