package p29;

/**
 * 数值的整数次方
 * @author Guozhu Zhu
 * @date 2018/8/18
 * @version 1.0
 *
 */
public class Test02 {
	
	public static void main(String[] args) {
		System.out.println(pow(2.6, 3));
		System.out.println(Math.pow(2.6, 3));
	}

	private static double pow(double base, int n) {
		double res = 1.0;
		for (int i = 0; i < Math.abs(n); i++) {
			res *= base;
		}
		if (n >= 0) {
			return res;
		} else {
			return 1 / res;
		}
	}
	
}
