package p25;

import java.util.HashMap;

/**
 * 爬楼梯简单问题, 一次可爬1和2阶
 * @author Guozhu Zhu
 * @date 2018/8/11
 * @version 1.0
 *
 */
public class Test02 {
	
	public static void main(String[] args) {
		solution1(10);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		solution2(10, map);
		solution3(10);
	}
	
	public static int solution1(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return solution1(n-1) + solution1(n-2);
	} 
	
	public static int solution2(int n, HashMap<Integer, Integer> map) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		} else {
			int value = solution2(n-1, map) + solution2(n-2, map);
			map.put(n, value);
			return value;
		}
	}
	
	public static int solution3(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int a = 1;
		int b = 2;
		int temp = 0;
		for (int i = 3; i <= n; i++) {
		    temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}

}
