package com.zhuguozhu.util;

/**
 * 双端队列简单实现(基于数组)
 * @author Guozhu Zhu
 * @date 2018/8/3
 * @version 1.0
 *
 */
public class DeQueueTest01<E> {
	
	public int head;
	
	public int tail;
	
	public int maxSize;
	
	public int size;
	
	public Object[] dequeue = {};
	
	public DeQueueTest01() {
		head = tail = size = 0;
		maxSize = 10;
		dequeue = new Object[maxSize];
	}
	
	public DeQueueTest01(int maxSize) {
		head = tail = size = 0;
		this.maxSize = maxSize;
		dequeue = new Object[this.maxSize];
	}
	
	//队头添加元素
	public boolean offerFirst(int item) {
		//判断队列是否已满
		if (size == maxSize) {
			return false;
		}
		head = (--head+ maxSize) % maxSize;
		dequeue[head] = item;
		size++;
		return true;
	}
	
	//队尾添加元素
	public boolean offerLast(int item) {
		//判断队列是否已满
		if (size == maxSize) {
			return false;
		}
		dequeue[tail] = item;
		tail = (tail+1) % maxSize;
		size++;
		return true;
	}
	
	//队头输出元素
	public int pollFirst() {
		if (size == 0) {
			return -1;
		}
		int temp = (int) dequeue[head];
		dequeue[head] = 0;
		head = (head + 1) % maxSize;
		size--;
		return (int) temp;
	}
	
	//队尾输出元素
	public int pollLast() {
		//判断队列是否为空
		if (size == 0) {
			return -1;
		}
		tail = (tail-- + maxSize) % maxSize;
		int temp = (int) dequeue[tail];                    
		dequeue[tail] = 0;
		size--;
		return temp;
	}
	
	public static void main(String[] args) {
		DeQueueTest01 dequeue = new DeQueueTest01();
		dequeue.offerLast(1);
		dequeue.offerLast(2);
		dequeue.offerLast(3);
		dequeue.offerLast(4);
		System.out.println(dequeue.pollLast());	
	}

}
