package p33;

import java.util.Scanner;

/**
 * 贪婪算法示例--解决找零钱问题；
 * @author Guozhu Zhu
 * @date 2018/8/30
 * @version 1.0
 *
 */
public class Test10 {
	
	public static int max = 10;
	
	public static int[] value = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10};
	
	public static int[] num = new int[max];
	
	/*========== Test ==========*/
	public static void main(String[] args) {
		System.out.println("输入零钱:");
		Scanner in = new Scanner(System.in);
		double n = in.nextDouble();
		exchange(n*100);
		for (int i = 0; i < num.length; i++) {
			if (num[i] > 0) {
				System.out.println("面值:" + value[i] / 100.0 + "张数:" + num[i]);
			}
		}
	}
	
	public static void exchange(double n) {
		int i;
		for (i = 0; i < value.length; i++) {
			if (n > value[i]) {
				break;
			}
		}
		while (n > 0 && i < value.length) {
			if (n >= value[i]) {
				n -= value[i];
				num[i]++;
			} else if (n < 10 && n >= 5) {
				num[value.length-1]++;
				break;
			} else {
				i++;
			}
		}
	}

}
