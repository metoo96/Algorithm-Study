package p39;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


 /** 数组中只出现一次的数字, 保存到num1[0]和num2[0]中;
  @author Guozhu Zhu
  @date 2018915
  @version 1.0
 */
 
public class FindNumsAppearOnce {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] num1 = new int[10];
		int[] num2 = new int[10];
		int[] array = {1, 1, 2, 2, 3, 4, 4, 5, 6, 6};
		findNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + ====== + num2[0]);
	}
	
	public static void  findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
		QueueInteger queue = new LinkedListInteger();
		HashMapInteger, Integer map = new HashMapInteger, Integer();
		for (int i = 0; i  array.length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], map.get(array[i])+1);
			}
		}
		for (int i = 0; i  array.length; i++) {
			if (map.get(array[i]) == 1) {
				queue.offer(array[i]);
			}
		}
		num1[0] = queue.poll();
		num2[0] = queue.poll();
	}

}
