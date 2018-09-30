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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            list.add(curNode.val);
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
                resList.add(list);
                list = new ArrayList<Integer>();
            }
        }
        Collections.reverse(resList);
        return resList;
    }
}