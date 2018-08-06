package p20;

/**
 * 重建二叉树(根据前序遍历+中序遍历)
 * @author Guozhu Zhu
 * @date 2018/8/6
 * @version 1.0
 *
 */
public class Test03<E> {
	
	//定义二叉树的节点结构
	private class TreeNode<E>{
		E val;
		public TreeNode<E> left;
		public TreeNode<E> right;
		public TreeNode() {
		}
		public TreeNode(E val) {
			this.val = val;
		}
	}
	
	//重建二叉树
	public TreeNode<E> reConstructBinaryTree(E[] preOrder, E[] inOrder) {
		if (preOrder.length != inOrder.length || preOrder == null || inOrder == null) {
			return null;
		}
		return reConstruct(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
	}
	
	//开始重建
	public TreeNode<E> reConstruct(E[] preOrder, int pStart, int pEnd, E[] inOrder, int iStart, int iEnd) {
		if (pStart > pEnd) {
			return null;
		}
		TreeNode<E> root = new TreeNode<E>(preOrder[pStart]);
		for (int index = iStart; index <= iEnd; index++) {
			if (inOrder[index] == preOrder[pStart]) {
				//重点是左右长度的计算：
				//左子树的长度为index-iStart 
				//右子树的长度为iEnd-index
				root.left = reConstruct(preOrder, pStart+1, pStart+index-iStart, inOrder, iStart, index-1);
			    root.right = reConstruct(preOrder, pStart+index-iStart+1, pEnd, inOrder, index+1, iEnd);
			}
		}
		return root;
	}
	
	//前序遍历二叉树
	public void PreTravel(TreeNode<E> treeNode) {
		if (treeNode == null) {
			return ;
		}
		System.out.println(treeNode.val);
		PreTravel(treeNode.left);
		PreTravel(treeNode.right);
	}
	
	//后序遍历二叉树
	public void EndTravel(TreeNode<E> treeNode) {
		if (treeNode == null) {
			return;
		}
		EndTravel(treeNode.left);
		EndTravel(treeNode.right);
		System.out.println(treeNode.val);
	}
	
	//中序遍历二叉树
	public void InTravel(TreeNode<E> treeNode) {
		if (treeNode == null) {
			return;
		}
		InTravel(treeNode.left);
		System.out.println(treeNode.val);
		InTravel(treeNode.right);
	}
	
	//========Test========
	public static void main(String[] args) {
		Test03<Integer> tree = new Test03<>();
	    Integer[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
		Integer[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
		Test03.TreeNode treeNode = tree.reConstructBinaryTree(preOrder, inOrder);
		tree.PreTravel(treeNode);
		tree.InTravel(treeNode);
	}

}
