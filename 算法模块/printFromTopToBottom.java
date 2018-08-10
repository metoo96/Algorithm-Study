package p24;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author Guozhu Zhu
 * @date 2018/8/10
 * @version 1.0
 *
 */
public class Test01 {
	
	public static ArrayList<Integer> printTopToBottom(TreeNode root) {
		 ArrayList<Integer> res = new ArrayList<Integer>();
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	        if (root == null) {
	            return res;
	        }
	        queue.offer(root);
	        while (!queue.isEmpty()) {
	            TreeNode current = queue.poll();
	            res.add(current.val);
	            if (current.left != null) {
	                queue.offer(current.left);
	            }
	            if (current.right != null) {
	                queue.offer(current.right);
	            }
	        }
	        return res;
	}

}
