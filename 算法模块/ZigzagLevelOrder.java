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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int mark = 0;
        int current = 1;
        int next = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            current--;
            list.add(curNode.val);
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
                if (mark % 2 != 0) {
                    Collections.reverse(list);
                }
                resList.add(list);
                mark++;
                list = new ArrayList<Integer>();
            }
        }
        return resList;
    }
    
}