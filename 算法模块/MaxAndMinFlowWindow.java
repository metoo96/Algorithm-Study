package p25;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口最大值 / 最小值
 * [注意]注意关注循环的起始点、 利用双端队列可尾部+头部移除元素
 * @author Guozhu Zhu
 * @date 2018/8/12
 * @version 1.0
 *
 */
public class Test08 {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 5, 9, -1};
		//滑动窗口最大值： 3， 5， 9， 9
		ArrayList<Integer> res = maxWindow(arr, 3);
		for (Integer i : res) {
			System.out.println(i);
		}
	}
	
	/**
	 * 求解滑动窗口最大值
	 * @param arr    数组
	 * @param size   窗口大小
	 * @return       滑动窗口最大值
	 */
	public static ArrayList<Integer> maxWindow(int[] arr, int size) {
		ArrayList<Integer> resList = new ArrayList<>();
		//1.判断是否异常情况
		if (arr == null || arr.length <= 0 || size == 0 || size > arr.length) {
			return resList;
		}
		ArrayDeque<Integer> dequeue = new ArrayDeque<>();
		//2.首次循环到滑动窗口大小减1, 双端队列保存的是可能为最大值的索引
		for (int i = 0; i < size-1; i++) {
			while (!dequeue.isEmpty() && arr[i] > arr[dequeue.getLast()]) {
				dequeue.removeLast();
			}
			dequeue.addLast(i);
		}
		//3.再次循环
		for (int i = size-1; i < arr.length; i++) {
			while (!dequeue.isEmpty() && arr[i] > arr[dequeue.getLast()]) {
				dequeue.removeLast();
			}
			dequeue.addLast(i);
			//判断是否超过了滑动窗口的范围区间
			if (i-dequeue.getFirst()+1 > size) {
				dequeue.removeFirst();
			}
			resList.add(arr[dequeue.getFirst()]);
		}
		return resList;
	}
	
	/**
	 * 求解滑动窗口最小值(求解滑动窗口最大值的变形)
	 * @param arr    数组
	 * @param size   滑动窗口的大小
	 * @return       滑动窗口最小值
	 */
	public static ArrayList<Integer> minWindow(int[] arr, int size) {
		ArrayList<Integer> resList = new ArrayList<>();
		if (arr.length <= 0 || arr == null || size <= 0 || size > arr.length) {
			return resList;
		}
		LinkedList<Integer> dequeue = new LinkedList<>();
		//与求解最大滑动窗口的算法思想基本一致
		for (int i = 0; i < size-1; i++) {
			while (!dequeue.isEmpty() && arr[i] < arr[dequeue.getLast()]) {
				dequeue.removeLast();
			}
			dequeue.addLast(i);
		}
		for (int i = size-1; i < arr.length; i++) {
			while (!dequeue.isEmpty() && arr[i] < arr[dequeue.getLast()]) {
				dequeue.removeLast();
			}
			dequeue.addLast(i);
			if (i-dequeue.getFirst()+1 > size) {
				dequeue.removeFirst();
			}
			resList.add(arr[dequeue.getFirst()]);
		}
		return resList;
	}

}
