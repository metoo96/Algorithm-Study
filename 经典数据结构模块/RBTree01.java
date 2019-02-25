package p52;

/**
 * 红黑树是一种应用广泛的二叉树
 * 1. 每个节点要么为黑色，要么为红色
 * 2. 根节点为黑色
 * 3. 每一个叶子节点是黑色的
 * 4. 如果该节点是红色的，那么它的孩子节点为黑色
 * 5. 从任意节点到叶子节点，经过的黑色节点个数都是相同的
 * Todo: 红黑树的删除操作
 * @author Guozhu Zhu
 * @date 2019/2/25
 * @version 1.0
 *
 */
public class RBTree01<K extends Comparable<K>, V>{
	
	//节点定义
	public class Node {
		public K key;
		public V value;
		public Node left;
		public Node right;
		public boolean color;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			color = RED;
		}
		}
	public static final boolean RED = true;
	public static final boolean BLACK = false;
	private Node root;
	private int size;
	public RBTree01() {
		root = null;
		size = 0;
	}
	
	//红黑树的基本方法
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	private boolean isRed(Node node) {
		if (node == null) {
			return BLACK;
		}
		return node.color;
	}
	
	/**
	 *leftRotate: 左黑右红
	 *    node                 x
	 *    / \                 / \
	 *   T1  x      ---->  node  T3
	 *      / \            / \
	 *     T2  T3        T1  T2
	 */
	public Node leftRotate(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;
	    x.color = node.color;
	    node.color = RED;
	    return x;
	}
	
	/**
	 * rightRotate: 左黑左子黑
	 *     node                    x
	 *     / \                    / \
	 *    x   T3    ---->        T1  node
	 *   / \                         / \
	 *  T1 T2                       T2  T3
	 */
	public Node rightRotate(Node node) {
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}
	
	/**
	 * flipcolors: 左红右红
	 */
	private void flipColors(Node node) {
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}
	
	public void add(K key, V value) {
		root = add(root, key, value);
	}
	
	public Node add(Node node, K key, V value) {
		if (node == null) {
			size++;
			return new Node(key, value);
		}
		if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		} else if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		} else {
			node.value = value;
		}
		if (isRed(node.right) && !isRed(node.left)) {
			node = leftRotate(node);
		} 
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rightRotate(node);
		} 
		if (isRed(node.left) && isRed(node.right)) {
			flipColors(node);
		}
		return node;
	}
	
	private Node getNode(Node node, K key) {
		if (node == null) {
			return null;
		}
		if (key.compareTo(node.key) > 0) {
			return getNode(node.right, key);
		} else if (key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		} else {
			return node;
		}
	}
	
	//是否包含某一个key
	public boolean contains(K key) {
		return getNode(root, key) == null ? false : true;
	}
	
	//根据key找值
	public V get(K key) {
		Node node = getNode(root, key);
		if (node == null) {
			return null;
		}
		return node.value;
	}
	
	public void set(K key, V value) {
		Node node = getNode(root, key);
		if (node == null) {
			return;
		}
		node.value = value;
	}

}
