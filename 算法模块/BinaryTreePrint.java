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
* 之字型打印字符串
* @author Guozhu Zhu
* @date 2018/8/10
* @version 1.0
*/
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (pRoot == null) {
            return resList;
        }
        int mark = 0;
        int current = 1;
        int next = 0;
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
                if (mark % 2 == 0) {
                    resList.add(list);
                } else {
                    Collections.reverse(list);
                    resList.add(list);
                }
                mark++;
                list = new ArrayList<Integer>();
            }
        }
        return resList;
    }

}