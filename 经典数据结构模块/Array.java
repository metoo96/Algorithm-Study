package com.zhuguozhu.util2;

/**
 * #Day01 集合框架--用静态数组打造动态数组
 * @author Guozhu Zhu
 * @date 2018/9/19
 * @version 1.0 
 *
 */
public class Array<E>{
	
	private E[] data;
	
	private int size;
	
	public Array() {
		this(10);
	}
	
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	//1. 获取数组容量
	public int getCapacity() {
		return data.length;
	}
	
	//2. 获取数组元素个数
	public int getSize() {
		return this.size;
	}
	
	//3. 判断数组是否为空
	public boolean isEmpty() {
		return this.size==0;
	}
	
	//4. 当数组元素已经满的时候，我们需要进行扩容
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = this.data[i];
		}
		this.data = newData;
	}
	
	/* ========== 添加元素 ========== */
	//在某一位置插入一个元素
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index error");
		}
		if (size == data.length) {
			resize(2*data.length);
		}
		for (int i = size-1; i >= index; i--) {
			data[i+1] = data[i];
		}
		data[index] = e;
	}
	
	//在第一个位置插入一个元素
	public void addFirst(E e) {
		add(0, e);
	}
	
	//在数组最后添加一个元素
	public void addLast(E e) {
		if (size == data.length) {
			throw new IllegalArgumentException("index error");
		}
		data[size] = e;
		size++;
	}
	
	/* ========== 删除元素 ========== */
	// 删除某个索引下面的元素
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index error");
		}
		E ret = data[index];
		for (int i = index+1; i < size;i++) {
			data[i-1] = data[i];
		}
		size--;
		if (size == data.length >> 2 && size > 1) {
			resize(data.length >> 1); //缩小原来的一半
		}
		return ret;
	}
	
	//安装元素删除
	public void removeElement(E e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
		}
		return;
	}
	
	//
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(this.size-1);
	}
	
	/* ========== 修改元素 ========== */
	public void set(int index, E e) {
		if (size == data.length) {
			throw new IllegalArgumentException("index error");
		}
		data[index] = e;
	}
	
	/* ========== 查询元素 ========= */
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	//查找是否存在一个元素
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	//获取元素
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("index error");
		}
		return data[index];
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size);
	}

}
