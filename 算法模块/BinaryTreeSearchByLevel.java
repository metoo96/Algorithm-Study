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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
       
        int current = 1;
        int next = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
         if (pRoot == null) {
            return resList;
        }
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            list.add(currentNode.val);
            current--;
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                next++;
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                next++;
            }
            if (current == 0) {
                current = next;
                next = 0;
                resList.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return resList;
    }
    
}