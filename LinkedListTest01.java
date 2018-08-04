package com.zhuguozhu.util;



/**
 * 双向链表的简单实现(后期再补充更多方法)
 * @author Guozhu zhu
 * @date 2018/8/4
 * @version 1.0
 *
 */
public class LinkedListTest01<E> {
	
	public transient int size;
	
	public transient Node<E> first;
	
	public transient Node<E> last;
	
	public LinkedListTest01() {	
	}
	
	//添加元素(头添加)
	public void addFirst(E e) {
		final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
        	last = newNode;
        } else {
        	f.prev = newNode;
        }
        size++;
	}
	
	//添加元素(尾添加)
	public void addLast(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node(l, e, null);
		last = newNode;
		if (last == null) {
			first = null;
		} else {
			l.next = newNode;
		}
		size++;
	}
	
	//查找元素(从链表头开始)
	public int findFist(E e) {
		int index = 0;
		for (Node<E> x = first; x != null; x = x.next) {
			if (x.item == e) {
				return index;
			}
			index++;
		}
		return -1;
 	}
	
	//查找链表第一个元素
	public E findFirstElement() {
		if (first != null) {
			return first.item;
		}
		return null;
	}
	
	//查找元素 (从链表尾开始)
	public int findLast(E e) {
		int index = 0;
		for (Node<E> x = last; x != null; x = x.prev) {
			if (x.item == e) {
				return index;
			}
		}
		return index;
	}
	
	//查找链表的最后一个元素
	public E findLastElement() {
		if (last != null) {
			return last.item;
		}
		return null;
	}
	
	//输出链表内的元素
	public void print() {
		for (Node<E> x = first; x != null; x = x.next) {
			System.out.println(x.item);
		}
	}
	
	//链表节点的结构
	private static class Node<E> {
		E item; //节点的内容
		Node<E> prev; //节点的上一个元素
		Node<E> next; //节点的下一个元素
		public Node () {
			
		}
		
		public Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.prev = prev;
			this.next = next;
		}
	}
	
	//转化为数组
	private Object[] toArray() {
		Object[] arr = new Object[size];
		int i = 0;
		for (Node<E> x = first; x != null; x = x.next) {
			arr[i++] = x.item;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		LinkedListTest01 list =new  LinkedListTest01();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.print();
		System.out.println(list.findFirstElement());
		System.out.println(list.findLastElement());
		Object[] arr = list.toArray();
		for (Object i : arr) {
			System.out.println(i);
		}
	}

}
