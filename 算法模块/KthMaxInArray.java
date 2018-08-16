package p28;

import java.util.PriorityQueue;

/**
 * 数组中最小的k个元素
 * @author Guozhu Zhu
 * @date 2018/8/16
 * @version 1.0
 *
 */
public class Test01 {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();  //默认是小顶堆的实现
		int[] arr = new int[] {1, 2, 4, 3, 6, 5, 7, 8, 9};     //数组
		for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
		}
		int k = 4;
		for (int i = 0; i < 4; i++) {
			System.out.println(queue.poll());
		}
	}

}
