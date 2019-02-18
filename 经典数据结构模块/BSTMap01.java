package p50;

/**
 * 实现基于BST的Map
 * @author Guozhu Zhu
 * @date 2019/2/18
 * @version 1.0
 *
 */
public class BSTMap01<K extends Comparable<K>, V> {
	
	private class BST<K extends Comparable<K>, V> {
		private class Node {
			public K key;
			public V value;
			public Node left;
			public Node right;
			public Node(K key, V value) {
				this.key = key;
				this.value = value;
				this.left = null;
				this.right = null;
			}
		}
		private Node root;
		private int size;
		public void add(K key, V value) {
		    root = add(root, key, value);
		}
		
		//改进的递归算法
		private Node add(Node node, K key, V value) {
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
			return node;
		}
		
		public int getSize() {
			return this.size;
		}
		
		public boolean isEmpty() {
			return this.size == 0;
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
		
		private boolean contains(K key) {
			return getNode(root, key) != null;
		}
		
		//获取元素
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
				throw new IllegalArgumentException("error");
			}
			node.value = value;
		}
		
		//删除任意节点
		public V remove(K key) {
			Node node = getNode(root, key);
			if (node == null) {
				return null;
			}
			root = removeElement(root, key);
			return node.value;
		}
		
		public Node removeElement(Node node, K key) {
			if (node == null) {
				return null;
			}
			if (key.compareTo(node.key) > 0) {
				node.right = removeElement(node.right, key);
				return node;
			} else if (key.compareTo(node.key) < 0) {
				node.left = removeElement(node.left, key);
				return node;
			} else {
				//要删除的是这个节点
				if (node.left == null) {
					Node rightNode = node.right;
					node.right = null;
					size--;
					return rightNode;
				} else if (node.right == null) {
					Node leftNode = node.left;
					node.right = null;
					size--;
					return leftNode;
				} else {
					//待删除的节点左右节点都不为空
					Node successor = minElement(root);
					successor.right = removeMinElement(root);
					size++;
					successor.left = node.left;
					node.left = node.right = null;
					size--;
					return successor;
				}
			}
		}
		
		private Node minElement(Node node) {
			if (node.left == null) {
				return node;
			}
			return minElement(node.left);
		}
		
		private Node removeMinElement(Node node) {
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			node.left = removeMinElement(node.left);
			return node;
		}
		
	}
	
	private BST<K, V> bst;
	public BSTMap01() {
		bst = new BST<K, V>();
	}
	
	public void add(K key, V value) {
		bst.add(key, value);
	}
	
	public V remove(K key) {
		return bst.remove(key);
	}
	
	//判断是否包含
	public boolean contains(K key) {
		return bst.contains(key);
	}
	
	//通过key查询value
	public V get(K key) {
		return bst.get(key);
	}
	
	//修改map中某一元素
	public void set(K key, V value) {
		bst.set(key, value);
	}
	
	//获取元素个数
	public int getSize() {
		return bst.getSize();
	}
	
	//判断map是否为空
	public boolean isEmpty() {
		return bst.isEmpty();
	}
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		BSTMap01<Integer, Integer> bstmap = new BSTMap01<>();
		for (int i = 0; i < 10; i++) {
			bstmap.add(i, i);
		}
		System.out.println(bstmap.getSize());
		System.out.println(bstmap.get(9));
		int ans = bstmap.remove(1);
		System.out.println(ans);
		System.out.println(bstmap.getSize());
		System.out.println(bstmap.get(1));
	}

}
