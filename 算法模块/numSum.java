package p32;

/**
 * 数位之和
 * @author Guozhu Zhu
 * @date 2018/8/25
 * @version 1.0
 *
 */
public class Test09 {
	
	public static void main(String[] args) {
		System.out.println(numSum(1110));
	}
	
	public static int numSum(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

}
