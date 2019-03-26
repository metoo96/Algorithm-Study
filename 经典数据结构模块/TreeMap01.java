package p56;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


/**
 * 红黑树 -- 手撕红黑树 （情况太多了，还是要patient点啊啊啊!!!）
 * @author Guozhu Zhu
 * @date 2019/3/27
 * @version 1.0
 *
 */
public class TreeMap01<K extends Comparable<K>, V> {
	
	private transient Entry<K, V> root;
	
	private transient int size = 0;
	
	public TreeMap01() {

	}

	public int size() {
		return size;
	}
	
	public boolean containsKey(K key) {
		return getEntry(key) != null;
	}
	
	public boolean containsValue(Object value) {
		for (Entry<K, V> e = getFirstEntry(); e != null; e = successor(e)) {
			if (valEquals(value, e.value)) {
				return true;
			}
			return false;
		}
		return false;
	}

	public V get(K key) {
		Entry<K, V> p = getEntry(key);
		return (p == null ? null : p.value);
	}
	
	public K firstKey() {
		return key(getFirstEntry());
	}
	
	public K lastKey() {
		return key(getLastEntry());
	}
	
	final Entry<K, V> getEntry(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		Entry<K, V> p = root;
		while (p != null) {
			int cmp = key.compareTo(p.key);
			if (cmp > 0) {
				p = p.right;
			} else if (cmp < 0){
				p = p.left;
			} else {
				return p;
			}
		}
		return null;
	}
	
	public V put(K key, V value) {
		Entry<K, V> t = root;
		if (t == null) {
			root = new Entry<>(key, value, null);
			size++;
			return null;
		}
		int cmp;
		Entry<K, V> parent;
		if (key == null) {
			throw new NullPointerException();
		}
		do {
			parent = t;
			cmp = key.compareTo(t.key);
			if (cmp < 0) {
				t = t.left;
			} else if (cmp > 0) {
				t = t.right;
			} else {
				return t.setValue(value);
			}
		} while (t != null);
		Entry<K, V> e = new Entry<>(key, value, parent);
		if (cmp < 0) {
			parent.left = e;
		} else {
			parent.right = e;
		}
		fixAfterInsertion(e);
		size++;
		return null;
	}
	
	public V remove(K key) {
		Entry<K, V> p = getEntry(key);
		if (p == null) {
			return null;
		}
		V oldValue = p.value;
		deleteEntry(p);
		return oldValue;
	}
	
	public V replace(K key, V value) {
		Entry<K, V> p = getEntry(key);
		if (p != null) {
			V oldValue = p.value;
			p.value = value;
			return oldValue;
		}
		return null;
	}
	
	static final boolean valEquals(Object o1, Object o2) {
		return (o1 == null ? o2 == null : o1.equals(o2));
	}
	
	static <K, V>  K keyOrNull(Entry<K, V> e) {
		return (e == null) ? null : e.key;
	}
	
	static <K> K key(Entry<K, ?> e) {
		if (e == null) {
			throw new NoSuchElementException();
		}
		return e.key;
	}
	
	//RB-Tree
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	static final class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> left;
		Entry<K, V> right;
		Entry<K, V> parent;
		boolean color = BLACK;
		Entry(K key, V value, Entry<K, V> parent) {
			this.key = key;
			this.value = value;
			this.parent = parent;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
		
		public boolean equals(Object o) {
			if (!(o instanceof Entry)) {
				return false;
			}
			Entry<?, ?> e = (Entry<?, ?>) o;
			return valEquals(key, e.getKey()) && valEquals(value, e.getValue());
		}
		
		public int hashCode() {
			int keyHash = (key == null) ? 0 : key.hashCode();
			int valueHash = (value == null) ? 0 : value.hashCode();
			return keyHash ^ valueHash;
		}
		
		public String toString() {
			return key + "=" + value;
		}
	}
	
	final Entry<K, V> getFirstEntry() {
		Entry<K, V> p = root;
		if (p != null) {
			while (p.left != null) {
				p = p.left;
			}
		}
		return p;
	}
	
	final Entry<K, V> getLastEntry() {
		Entry<K, V> p = root;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
		}
		return p;
	}
	
	//返回被删除节点的继承者节点
	static <K, V> Entry<K, V> successor(Entry<K, V> t) {
		if (t == null) {    //如果被删除节点为空，则直接返回null
			return null;
		} else if (t.right != null) {    //如果被删除节点的右子节点不为空
			Entry<K, V> p = t.right;    //将被删除节点的右子节点记录下来
			while (p.left != null) {    //从该节点开始循环向下查找左子节点，直至找到叶子节点后返回该叶子节点
				p = p.left;
			}
			return p;
		} else {    //如果被删除节点的右子节点为空
			Entry<K, V> p = t.parent;  //将被删除节点用p变量记录
			Entry<K, V> ch = t;    //被删除节点用ch变量记录
			//从被删除节点开始循环向上查找父节点，直到父节点为空或父节点没有右子节点，返回该父节点
			while (p != null && ch == p.right) {
				ch = p;
				p = p.parent;
			}
			return p;
		}
	}
	
	static <K, V> Entry<K, V> predecessor(Entry<K, V> t) {
		if (t == null) {
			return null;
		} else if (t.left != null) {
			Entry<K, V> p = t.left;
			while (p.right != null) {
				p = p.right;
			}
			return p;
		} else {
			Entry<K, V> p = t.parent;
			Entry<K, V> ch = t;
			while (p != null && ch == p.left) {
				ch = p;
				p = p.parent;
			}
			return p;
		}
	}
	
	private static <K, V> boolean colorOf(Entry<K, V> p) {
		return (p == null ? BLACK : p.color);
	}
	
	private static <K, V> Entry<K, V> parentOf(Entry<K, V> p) {
		return (p == null ? null : p.parent);
	}
	
	private static <K, V> void setColor(Entry<K, V> p, boolean c) {
		if (p != null) {
			p.color = c;
		}
	}
	
	private static <K, V> Entry<K, V> leftOf(Entry<K, V> p) {
		return (p == null) ? null : p.left;
	}
	
	private static <K, V> Entry<K, V> rightOf(Entry<K, V> p) {
		return (p == null) ? null : p.right;
	}
	
	//左旋
    private void rotateLeft(Entry<K, V> p) {
    	if (p != null) {
    		Entry<K, V> r = p.right;
    		p.right = r.left;
    		if (r.left != null) {
    			r.left.parent = p;
    		}
    		r.parent = p.parent;
    		if (p.parent == null) {
    			root = r;
    		} else if (p.parent.left == p) {
    			p.parent.left = r;
    		} else if (p.parent.right == p){
    			p.parent.right = r;
    		}
    		r.left = p;
    		p.parent = r;
    	}
     }
    
     //右旋
     private void rotateRight(Entry<K, V> p) {
    	 if (p != null) {
    		 Entry<K, V> l = p.left;
    		 p.left = l.right;
    		 if (l.right != null) {
    			 l.right.parent = p;
    		 } 
    		 l.parent = p.parent;
    		 if (p.parent == null) {
    			 root = l;
    		 } else if (p.parent.left == p) {
    			 p.parent.left = l;
    		 } else if (p.parent.right == p){
    			 p.parent.right = l;
    		 }
    		 l.right = p;
    		 p.parent = l;
    	 }
     }
     
     //树插入一个新节点后，将其根据红黑树的规则进行修正
     private void fixAfterInsertion(Entry<K, V> x) {
    	 //默认将当前插入树的节点颜色设置为红色，为什么？？？
    	 //因为红黑树有一个特性：“从根节点到所有叶子节点上的黑色节点数量是相同的
    	 //如果当前插入的节点是黑色的，那么必然会违反这个特性，所以必须将插入节点的颜色先设置为红色
    	 x.color = RED;
    	 //第一次遍历时， x变量保存的时当前新插入的节点
    	 //为什么要用while循环
    	 //因为在旋转过程中可能还会出现父子节点均为红色的情况，所以要不断向上变量直到整个树都符合红黑树的规则
    	 while (x != null && x != root && x.parent.color == RED) {
    		 //如果当前节点不为空且不是根节点，并且当前节点的父节点颜色为红色
    		 if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
    			 //如果当前节点的父节点等于当前节点父节点的父节点的左子节点（即当前节点为左子树插入
                 Entry<K, V> y = rightOf(parentOf(parentOf(x)));
                 //获取当前节点的叔父节点
                 if (colorOf(y) == RED) {
                	 //如果叔父节点的颜色为红色
                	 //以下4步用来保证不会连续出现两个红色节点
                	 setColor(parentOf(x), BLACK);
                	 //将当前节点的父节点设置为黑色
                	 setColor(y, BLACK);
                	 //将当前节点的叔父节点设置为黑色
                	 setColor(parentOf(parentOf(x)), RED);
                	 //将当前节点的祖父节点设置为红色
                	 x = parentOf(parentOf(x));
                	 //当前遍历节点变更为当前节点的祖父节点
                 } else {
                	 //如果叔父节点的颜色为黑色，或没有叔父节点
                	 if (x == rightOf(parentOf(x))) {
                		 //如果当前节点为左子树内侧插入
                		 x = parentOf(x);
                		 //将x变更为当前节点的父节点
                		 rotateLeft(x);
                		 //对当前节点的父节点进行一次左旋操作（旋转完毕后x对应的就是最左边的叶子节点
                	 }
                	 //如果当前节点为左子树外侧插入
                	 setColor(parentOf(x), BLACK);
                	 //将当前节点的父节设置为黑色
                	 setColor(parentOf(parentOf(x)), RED);
                	 //将当前节点的祖父节点设置为红色
                	 rotateRight(parentOf(parentOf(x)));
                	 //对当前节点祖父节点进行一次右旋
                 }
    		 } else {
    			  Entry<K,V> y = leftOf(parentOf(parentOf(x)));
                  if (colorOf(y) == RED) {
                      setColor(parentOf(x), BLACK);
                      setColor(y, BLACK);
                      setColor(parentOf(parentOf(x)), RED);
                      x = parentOf(parentOf(x));
                  } else {
                      if (x == leftOf(parentOf(x))) {
                          x = parentOf(x);
                          rotateRight(x);
                      }
                      setColor(parentOf(x), BLACK);
                      setColor(parentOf(parentOf(x)), RED);
                      rotateLeft(parentOf(parentOf(x)));
                  }
    		 }
    	 }
    	 root.color = BLACK;//注意在旋转的过程中可能将根节点变更为红色的，但红黑树的特性要求根节点必须为黑色，所以无论如何最后总要执行这行代码,将根节点设置为黑色
     }
	
     private void deleteEntry(Entry<K, V> p) {
    	 size--; //节点总数-1
    	 if (p.left != null && p.right != null) {
    		 //当前要删除节点的左右节点都不为空
    		 Entry<K, V> s = successor(p);
    		 //找到一个带删除节点的继承者节点s
    		 p.key = s.key;
    		 p.value = s.value;
    		 p = s;
    		 //此时，p的后继节点s不可能为双子非空。
    	 }
    	 
    	 //替代节点选择为当前删除节点的左子节点或右子节点
    	 Entry<K, V> replacement = (p.left != null ? p.left : p.right);
    	 //替代节点（被删除节点的子节点）不为空
    	 if (replacement != null) {
    		 replacement.parent = p.parent;
    		 //将替代节点的父节点指向被删除节点父节点
    		 if (p.parent == null) {
    			 //如果被删除节点的父节点为null
    			 root = replacement;
    			 //则将根节点设置为替换节点
    		 } else if (p == p.parent.left) {
    			 //如果原先被删除节点时左子树插入
    			 p.parent.left = replacement;
    			 //则将替换节点也保持左子树插入
    		 } else {
    			 p.parent.right = replacement;
    		 }
    		 p.left = p.right = p.parent = null;
    		 //将被删除节点的左子节点，右子节点，父节点引用都设置null
    		 
    		 //删除后要执行后续的保证红黑树规则的操作
    		 if (p.color == BLACK) {
    			 //如果被删除节点是黑色的
    			 fixAfterDeletion(replacement);
    		 }
    			 //调用删除后修正红黑树规则的方法
    		 } else if (p.parent == null) {
    			 //没有儿子(且为根节点)
    			 //被删除节点就是根节点
    			 root = null;
    		 } else {
    			 //被删除节点没有节点可替代的情况（被删除是叶子节点）
    			 if (p.color == BLACK) {
    				 fixAfterDeletion(p);
    			 }
    			 if (p.parent != null) {
    				 //如果被删除节点的父节点不为null
    				 if (p == p.parent.left) {
    					 //如果原先被删除节点是左子树插入
    					 p.parent.left = null;
    					 //删除节点后将被删除节点的父节点的左子节点设置为null
    				 } else if (p == p.parent.right) {
    					 p.parent.right = null;
    				 }
    				 p.parent = null;
    				 //将被删除节点的父节点引用设置为null
    			 }
    		 }
    	 }
     
     private void fixAfterDeletion(Entry<K, V> x) {
    	 //循环遍历，x刚开是为被删除节点
    	 while (x != root && colorOf(x) == BLACK) {
    		 //如果当前遍历到的节点不是根节点且为黑色
    		 if (x == leftOf(parentOf(x))) {
    			 //如果当前遍历的节点是父节点的左节点
    			 Entry<K, V> sib = rightOf(parentOf(x));
    			 //将当前遍历到的节点的父节点的右节点用sib保存
    			 if (colorOf(sib) == RED) {
    				 //如果sib引用的节点是红色的
    				 setColor(sib, BLACK);
    				 //将sib引用的节点设置为黑色
    				 setColor(parentOf(x), RED);
    				 //将当前遍历到的节点的父节点设置红色
    				 rotateLeft(parentOf(x));
    				 //对当前遍历到的父节点进行一次左旋
    				 sib = rightOf(parentOf(x));
    				 //sib引用的节点变更为旋转后被删除节点的父节点的右子节点
    			 }
    			 
    			 if (colorOf(leftOf(sib)) == BLACK 
    			    && colorOf(rightOf(sib)) == BLACK) {
    				 //如果sib引用的左右节点都是黑色的
    				 setColor(sib, RED);
    				 //将sib引用的节点设置为红色
    				 x = parentOf(x);
    				 //下次遍历的节点变更为当前遍历到节点的父节点
    			 } else {
    				 //如果sib引用节点的左右节点不全是黑色的
    				 if (colorOf(rightOf(sib)) == BLACK) {
    					 //如果sib引用节点右节点是黑色
    					 setColor(leftOf(sib), BLACK);
    					 //将sib引用的左子节点设置为黑色
    					 setColor(sib, RED);
    					 //sib引用节点设置为红色
    					 rotateRight(sib);
    					 //对sib节点进行一次右旋操作
    					 sib = rightOf(parentOf(x));
    					 //sib引用的节点变更为当前遍历到的节点的父节点的右子节点
    					 
    				 } 
    				 setColor(sib, colorOf(parentOf(x)));
    				 //将sib引用节点的颜色设置为当前遍历到节点父节点的颜色
    				 setColor(parentOf(x), BLACK);
    				 //将当前遍历到节点的父节点设置为黑色
    				 setColor(rightOf(sib), BLACK);
    				 //将sib引用节点的右子节点设置为黑色
    				 rotateLeft(parentOf(x));
    				 //对当前遍历到的节点的父节点进行一次左旋
    				 x = root;
    				 //下一次遍历的节点变更为根节点
    			 }
    		 } else {
    			 //当前遍历到的节点是其父节点的右子节点
                 Entry<K,V> sib = leftOf(parentOf(x));

                 if (colorOf(sib) == RED) {
                     setColor(sib, BLACK);
                     setColor(parentOf(x), RED);
                     rotateRight(parentOf(x));
                     sib = leftOf(parentOf(x));
                 }

                 if (colorOf(rightOf(sib)) == BLACK &&
                     colorOf(leftOf(sib)) == BLACK) {
                     setColor(sib, RED);
                     x = parentOf(x);
                 } else {
                     if (colorOf(leftOf(sib)) == BLACK) {
                         setColor(rightOf(sib), BLACK);
                         setColor(sib, RED);
                         rotateLeft(sib);
                         sib = leftOf(parentOf(x));
                     }
                     setColor(sib, colorOf(parentOf(x)));
                     setColor(parentOf(x), BLACK);
                     setColor(leftOf(sib), BLACK);
                     rotateRight(parentOf(x));
                     x = root;
                 }
    		 }
    	 }
     setColor(x, BLACK);
    }
     
     //层次遍历
     public ArrayList<ArrayList<V>> levelOrder() {
     	ArrayList<ArrayList<V>> resList = new ArrayList<ArrayList<V>>();
     	ArrayList<V> list = new ArrayList<V>();
     	Queue<Entry> queue = new LinkedList<Entry>();
     	queue.offer(root);
     	int cur = 1;
     	int next = 0;
     	while (!queue.isEmpty()) {
     		Entry<K, V> curNode = queue.poll();
     		list.add(curNode.value);
     		cur--;
     		if (curNode.left != null) {
     			queue.offer(curNode.left);
     			next++;
     		} 
     		if (curNode.right != null) {
     			queue.offer(curNode.right);
     			next++;
     		}
     		if (cur == 0) {
     			cur = next;
     			next = 0;
     			resList.add(list);
     			list = new ArrayList<V>();
     		}
     	}
     	return resList;	
     }
     
     /* ========== Test ========== */
     public static void main(String[] args) {
    	 TreeMap01<Integer, Integer> tree = new TreeMap01<Integer, Integer>();
    	 for (int i = 0; i < 20; i++) {
    		 tree.put(i, i);
    	 }
    	 tree.remove(7);
    	 ArrayList<ArrayList<Integer>> resList = tree.levelOrder();
    	 for (ArrayList<Integer> i : resList) {
    		 System.out.println(i);
    	 }
     }
     	
}
