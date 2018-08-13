package p26;

import java.util.HashMap;

/**
 * 动态规划的简单问题(爬楼梯问题详解)
 * @author Guozhu Zhu
 * @date 2018/8/13
 * @version 1.0
 *
 */
public class Test04 {
	
	//充当备忘录
	public static HashMap<Integer, Integer> cache = new  HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		System.out.println(Solution01(10));
		System.out.println(Solution02(10));
		System.out.println(Solution03(10));
	}
	
	//1. 递归求解
	private static int Solution02(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return Solution02(n-1) + Solution02(n-2);
	}

	//2. 递归+备忘录算法
	public static int Solution01(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (!cache.isEmpty() && cache.get(n) != null) {
			return cache.get(n);
		}
		return  Solution01(n-1)+Solution01(n-2);
	}
	
	//3. 简单的动态规划问题
	public static int Solution03(int n) {
		if (n == 0) {
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
			temp = a+b;
			a = b;
			b = temp;
		}
		return temp;
	}

}

