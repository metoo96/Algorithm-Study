package p47;

/**
 * 洗牌算法实现
 * @author Guozhu Zhu
 * @date 2019/1/25
 * @version 1.0
 *
 */
public class Shuffle01 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] cards = new int[54];
		shuffle(cards, 54);
	}
	
	public static void shuffle(int[] cards, int n) {
		for (int i = 0; i < n; i++) {
			cards[i] = i;
		}
		//Math.random函数返回0.0 ~ 1.0 之间的一个随机数
		for (int i = 0; i < n; i++) {
		    int r = (int) (i + (Math.random()*(n-i)));
			int temp = cards[i];
			cards[i] = cards[r];
			cards[r] = temp;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(cards[i]);
		}
	}

}
