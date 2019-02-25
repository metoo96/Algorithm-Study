package com.zhuguozhu.util6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树的实现
 * @author Guozhu Zhu
 * @date 2019/2/25
 * @version 1.0
 * @param <E>
 */
public class BST<E extends Comparable<E>>{
	
	private class Node {
		public E e;
		public Node left;
		public Node right;
		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	
	public int size;
	
	//BST的构造函数
	public BST() {
		root = null;
		size = 0;
	}
	
	//BST树的元素个数
	public int getSize() {
		return this.size;
	}
	
	//BST树是否为空
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	//addNode
	//添加一个元素
	public void add(E e) {
		root = add(root, e);
	}
	
	//改进递归算法， 添加元素
	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		} else if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		} else {
			node.e = e;
		}
		return node;
	}
	
	//查询节点是否存在
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		}
		if (e.compareTo(node.e) == 0) {
			return true;
		} else if (e.compareTo(node.e) < 0) {
			return contains(node.left, e);  //左子树
		} else {
			return contains(node.right, e); //右子树
		}
	}
	
	//二叉树前序遍历， 递归版本
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.e);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	//二叉树的中序遍历，递归版本
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.e);
		inOrder(root.right);
	}
	
	//二叉树的后序遍历，递归版本
	public void postOrder() {
		postOrder(root);
	}
	
	public void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.e);
	}
	
	//获取BST的最小值
	public E minElement() {
		if (size == 0) {
			throw new IllegalArgumentException("error");
		}
		return minElement(root).e;
	}
	
	public Node minElement(Node root) {
		if (root.left == null) {
			return root;
		}
		return minElement(root.left);
	}
	
	//获取BST的最大值
	public E maxElement() {
		if (size == 0) {
			throw new IllegalArgumentException("error");
		}
		return maxElement(root).e;
	}
	
	public Node maxElement(Node root) {
		if (root.right == null) {
			return root;
		}
		return maxElement(root.right);
	}
	
	//删除元素
	public void removeElement(E e){
	     removeElement(root, e);
	}
	
	private Node removeElement(Node node,E e){     
	    if (node == null)         
	       return null;     
	    if (e.compareTo(node.e) < 0) {
	        node.left=removeElement(node.left,e);         
	        return node;
	     }     
	   else if(e.compareTo(node.e)>0){
	      node.right = removeElement(node.right,e);         
	      return node;
	   }     
	   else{//要删除的是这个根节点
	        //如果待删除的节点的左节点为空
	       if(node.left==null){            
	           Node rightNode = node.right;
	           node.right=null;
	           size--;            
	           return rightNode;
	        }        
	       //待删除节点右节点为空
	      else if(node.right==null){            
	         Node leftNode = node.left;
	         node.left=null;
	         size--;            
	         return leftNode;
	      }        
	      else{
	    	//待删除节点左右节点不为空
	        //找后驱节点作为跟节点
	        Node nextRoot= minElement(node.right);
	        nextRoot.right=removeMinElement(node.right);
	        size++;//上面删除了节点的右边最小节点
	        nextRoot.left=node.left;
	        node.left=node.right=null;
	        size--;//node节点删除，size--
	        return nextRoot;
	     }
	  }
	}
	
	//删除最小值
	public E removeMinElement(){    
	    E ret = minElement();
	    root=removeMinElement(root);    
	    return ret;
	}
	private Node removeMinElement(Node node){    
	    if(node.left==null){       
	       Node rightNode = node.right;//保存右节点
	       node.right=null;
	       size--;       
	       return rightNode;
	    }
	    node.left = removeMinElement(node.left);    
	    return node;
	}

	//删除最大值
	public E removeMaxElement(){    
	    E ret = maxElement();
	    root=removeMaxElement(root);    
	    return ret;
	}
	private Node removeMaxElement(Node node){    
	    if(node.right==null){       
	       Node leftNode = node.left;//保存左节点
	       node.left=null;
	       size--;       
	      return leftNode;
	   }
	   node.right = removeMaxElement(node.right);    
	   return node;
	}
	
	public void levelOrder() {
		levelOrder(root);
	}
	
	private void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			System.out.println(curNode.e);
			if (curNode.left != null) {
				queue.offer(curNode.left);
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
			}
		}
	}
	
	
	//preOrder no-recursize
	public void newPreOrder() {
		newPreOrder(root);
	}
	
	private void newPreOrder(Node node) {
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		Node temp = node;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				System.out.println(temp.e);
				stack.push(temp);
				temp = temp.left;
			} 
			if (!stack.isEmpty()) {
				temp = stack.peek();
				stack.pop();
				temp = temp.right;
			}
		}
	}
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		for (int i = 0; i < 10; i++) {
			bst.add(i);
		}
		bst.removeElement(2);
		//bst.removeMinElement();
		//bst.removeMaxElement();
		//bst.inOrder();
		//bst.preOrder();
		//bst.levelOrder();
		bst.newPreOrder();
	}
	
}
