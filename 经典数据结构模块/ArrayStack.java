package com.zhuguozhu.util2;

/**
 * 基于数组的栈实现
 * @author Guozhu Zhu
 * @date 2018/9/22
 * @version 1.0
 *
 */
public class ArrayStack<E> implements Stack<E>{
    
	private Array<E> array;
	
	public ArrayStack() {
		array = new Array<E>();
	}
	
	public ArrayStack(int capacity) {
		array = new Array<E>(capacity);
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return array.isEmpty();
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return array.removeLast();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return array.getLast();
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		array.addLast((E)e);
	}

}
