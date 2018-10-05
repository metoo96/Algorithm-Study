package com.zhuguozhu.util3;

/**
* 双向链表的实现
* @author Guozhu Zhu
* @date 2018/10/5
* @version 1.0
*
*/
public class LinkedList01<E> {
	
	public int size = 0;
	
	public int modCount = 0;
	
	public Node<E> first;
	
	public Node<E> last;
	
	//节点的定义
	public static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;
		public Node() {
			
		}
		public Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public LinkedList01() {	
	}
	
	//node --> index
	public int IndexOf(Object o) {
		int index = 0;
		if (o == null) {
			for (Node<E> x = first; x != null; x = x.next) {
				index++;
				if (x.item == null) {
					return index;
				}
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next) {
				index++;
				if (o.equals(x.item)) {
					return index;
				}
			}
		}
		return -1;
	}
	
	//node --> index
	public int lastIndexOf(Object o) {
		int index = size;
		if (o == null) {
		    for (Node<E> x = last; x != null; x = x.prev) {
		    	index--;
		    	if (x.item == null) {
		    		return index;
		    	}
		    }
		} else {
			for (Node<E> x = last; x != null; x = x.prev) {
				index--;
				if (o.equals(x.item)) {
					return index;
				}
			}
		}
		return -1;
	}
	
	//index --> node
	public Node<E> node(int index) {
		if (index < (size>>1)) {
			Node<E> x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node<E> x = last;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
	}
	
	//checkPositionIndex
	public boolean checkPositionIndex(int index) {
		return index >= 0 && index <= this.size;
	}
    
	//checkElementIndex
	public boolean checkElementIndex(int index) {
		return index >= 0 && index < this.size;
	}
	
	//add
	public void add(int index, E element) {
		if(checkPositionIndex(index)) {
			if (index == size) {
				linkLast(element);
			}
		} else {
	           linkBefore(element, node(index));
		}
	}
	
	public boolean add(E e) {
		linkLast(e);
		return true;
	}
	
	public void addFirst(E element) {
		linkFirst(element);
	}
	
	public void addLast(E element) {
		linkLast(element);
	}
	
	public void linkLast(E e) {
		Node<E> l = this.last;
		Node<E> newNode = new Node<E>(l, e, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
		modCount++;
	}
	
	public void linkFirst(E e) {
		Node<E> f = this.first;
		Node<E> newNode = new Node<E>(null, e, first);
		first = newNode;
		if (first == null) {
			last = newNode;
		} else {
			f.prev = newNode;
		}
		size++;
		modCount++;
	}
	
	public void linkBefore(E element, Node<E> succ) {
		final Node<E> pred = succ.prev;
		final Node<E> newNode = new Node(pred, element, succ);
		succ.prev = newNode;
		if (pred == null) {
			first = newNode;
		} else {
			pred.next = newNode;
		}
		size++;
		modCount++;
	}
	
	public E get(int index) {
		if(checkElementIndex(index)) {
			return node(index).item;
		} else {
			throw new IllegalArgumentException("index error");
		}
	}
	
	public E getLast() {
		final Node<E> l = last;
		if (l == null) {
			throw new IllegalArgumentException("index error");
		}
		return l.item;
	}
	
	public E getFirst() {
		final Node<E> f = first;
		if (f == null) {
			throw new IllegalArgumentException("index error");
		}
		return f.item;
	}
	
	//set
	public E set(int index, E element) {
		if (checkElementIndex(index)) {
			Node<E> x = node(index);
			E oldVal = x.item;
			x.item = element;
			return oldVal;
 		} else {
 			throw new IllegalArgumentException("index error");
 		}
	}
	
	//clear
	public void clear() {
		for (Node<E> x = first; x != null; x = x.next) {
			x.item = null;
			x.prev = null;
			x.next = null;
		}
		first = last = null;
		size = 0;
		modCount = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Object e) {
		return IndexOf(e) != -1;
	}
	
	public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
        }
	
   public E remove(int index) {
        if(checkElementIndex(index)) {
        return unlink(node(index));
        } else {
        	throw new IllegalArgumentException("index error");
        }
    }
	
	public boolean remove(Object o) {
		if (o == null) {
			for (Node<E> x = first; x != null; x = x.next) {
				if (x.item == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next) {
				if (o.equals(x.item)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}
	
	public E removeFirst() {
		Node<E> f = first;
		if (f == null) {
			throw new IllegalArgumentException("index error");
		}
		return unlinkFirst(f);
	}
	
	public E removeLast() {
		Node<E> l = last;
		if (l == null) {
			throw new IllegalArgumentException("index error");
		}
		return unlinkLast(l);
	}
	
	public E unlinkFirst(Node<E> f) {
		final E element = f.item;
		final Node<E> next = f.next;
		final Node<E> prev = f.prev;
		f.item = null;
		f.next = null;
		first = next;
		if (next == null) {
			last = null;
		} else {
			next.prev = null;
		}
		size--;
		modCount++;
		return element;
	}
	
	public E unlinkLast(Node<E> l) {
		final E element = l.item;
		final Node<E> next = l.next;
		final Node<E> prev = l.prev;
		l.item = null;
		l.prev = null;
		l.next = null;
		last = prev;
		if (prev == null) {
			first = null;
		} else {
			prev.next = null;
		}
		size--;
		modCount++;
		return element;
	}
	
	public E unlink(Node<E> x) {
		final E element = x.item;
		final Node<E> next = x.next;
		final Node<E> prev = x.prev;
		if (prev == null) {
			first = next;
		} else {
			first.next = next;
			x.prev = null;
		}
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}
		x.item = null;
		size++;
		modCount++;
		return element;
	}
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		LinkedList01<Integer> list =new  LinkedList01<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		list.get(0);
		list.contains(1);
	}
	
}
