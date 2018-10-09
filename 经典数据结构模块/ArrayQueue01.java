package com.zhuguozhu.util3;

/**
 * 
 * @author Guozhu Zhu
 * @date 2018/10/09
 * @version 1.0
 *
 */
public class ArrayQueue01 {
	
	public Array01 array;
	
	public int size;
	
	public ArrayQueue01() {
		
	}
	
	public void offer(int e) {
		array.addLast(e);
	}
	
	public int poll() {
		return array.removeFirst();
	}
	
	public int peek() {
		return array.getFirst();
	}

}
