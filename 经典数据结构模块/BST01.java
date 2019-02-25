package p52;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST数据结构的实现
 * @author Guozhu Zhu
 * @date 2019/2/25
 * @version 1.0
 *
 */
public class BST01<E extends Comparable<E>> {
	
	private class Node {
		public E value;
		public Node left;
		public Node right;
		public Node(E value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public Node root;
	public int size;
	public BST01() {
		root = null;
		size = 0;
	}
    
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void add(E e) {
		root = add(root, e);
	}
	
	public Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.value) > 0) {
			node.right = add(node.right, e);
		} else if (e.compareTo(node.value) < 0) {
			node.left = add(node.left, e);
		} else {
			node.value = e;
		}
		return node;
	}
	
	public Node getNode(Node node, E e) {
		if (node == null) {
			return null;
		}
		if (e.compareTo(node.value) > 0) {
			return getNode(node.right, e);
		} else if (e.compareTo(node.value) < 0) {
			return getNode(node.left, e);
		} else {
			return node;
		}
	}
	
	public boolean contains(E e) {
		Node node = getNode(root, e);
		if (node == null) {
			return false;
		}
		return  true;
	}
	
	//前序遍历
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	//中序遍历
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.value);
		inOrder(node.right);
	}
	
	//后序遍历
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value);
	}
	
	//非递归前序遍历
	public void newPreOrder() {
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				System.out.println(temp.value);
				stack.push(temp);
				temp = temp.left;
			}
			if (!stack.isEmpty()) {
				temp = stack.pop();
				temp = temp.right;
			}
		}
	}
	
	//非递归中序遍历
	public void newInOrder() {
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			if (!stack.isEmpty()) {
				temp = stack.pop();
				System.out.println(temp.value);
				temp = temp.right;
			}
		}
	}
	
	//利用队列来实现层次遍历
	public void levelOrder() {
	    Queue<Node> queue = new LinkedList<Node>();
	    queue.offer(root);
	    while (!queue.isEmpty()) {
	    	Node curNode = queue.poll();
	    	System.out.println(curNode.value);
	    	if (curNode.left != null) {
	    		queue.offer(curNode.left);
	    	} 
	    	if (curNode.right != null) {
	    		queue.offer(curNode.right);
	    	}
	    }
	}
	
	//二叉树的最小值
	public E minElement() {
	    return minElement(root).value;
	}
	
	private Node minElement(Node node) {
		if (node.left == null) {
			return node;
		}
		return minElement(node.left);
	}
	
	//二叉树的最大值
	public E maxElement() {
		return maxElement(root).value;
	}
	
	private Node maxElement(Node node) {
		if (node.right == null) {
			return node;
		}
		return maxElement(node.right);
	}
	
	//删除指定元素
	public E removeElement(E e) {
		Node node = getNode(root, e);
		if (node == null) {
			return null;
		}
		root = removeElement(root, e);
		return node.value;
	}
	
	public Node removeElement(Node node, E e) {
		if (node == null) {
			return null;
		}
		if (e.compareTo(node.value) > 0) {
			node.right = removeElement(node.right, e);
			return node;
		} else if (e.compareTo(node.value) < 0) {
			node.left = removeElement(node.left, e);
			return node;
		} else {
			//删除该元素
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			} else if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			} else {
				Node successor = minElement(node.right);
				successor.right = removeMinElement(node.right);
				size++;
				successor.left = node.left;
				node.left = node.right = null;
				return successor;
			}
		}
	}
	
	public Node removeMinElement(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMinElement(node.left);
		return node;
	}
	
	public Node removeMaxElement(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMaxElement(node.right);
		return node;
	}
	
	/* ========== Test ========== 
	 * 测试的BST:
	 *             0
	 *              \
	 *               1 
	 *                \
	 *                 5
	 *                /
	 *               3
	 *              / \
	 *             2   4
	 */
	public static void main(String[] args) {
		BST01<Integer> bst = new BST01<>();
		bst.add(0);
		bst.add(1);
		bst.add(5);
		bst.add(3);
		bst.add(2);
		bst.add(4);
		//bst.inOrder();      //0, 1, 2, 3, 4, 5
		//bst.preOrder();     //0, 1, 5, 3, 2, 4
		//bst.postOrder();    //2, 4, 3, 5, 1, 0
		//bst.levelOrder();   //0, 1, 5, 3, 2, 4
		//bst.newPreOrder();
		//bst.newInOrder();
	}
	
}
