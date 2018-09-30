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
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<Integer>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int current = 1;
        int next = 0;
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if(curNode.val > max)  {
                max = curNode.val;
            }
            current--;
            if (curNode.left != null) {
                queue.offer(curNode.left);
                next++;
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                next++;
            }
            if (current == 0) {
                current = next;
                next = 0;
                resList.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return resList;
    }
    
}