package p43;

/**
 * kmp模式匹配算法实现
 * @author Guozhu Zhu
 * @date 2018/10/17
 * @version 1.0
 *
 */
public class Test06 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		String T = "gu";
		String S = "zhuguozhu";
		int[] next = getNext(T);
		int ans = Kmp(S, T, next);
		System.out.println(ans);
	}
	
	//减少了朴素模式匹配算法的回溯操作, Time:O(n)=n;
	public static int Kmp(String S, String T, int[] next) {
		char[] sArr = S.toCharArray();
		char[] tArr = T.toCharArray();
		if (sArr.length == 0 || tArr.length == 0) {
			return -1;
		}
		int i = 0;
		int j = 0;
		while (i < sArr.length && j < tArr.length) {
			if (j == -1 || sArr[i] == tArr[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j >= tArr.length) {
			return i-tArr.length;
		}
		return -1;
	}
	
	public static int[] getNext(String T) {
		char[] tArr = T.toCharArray();
		int[] next = new int[tArr.length];
		int j = 0;
		int k = -1;
		next[0] = -1;
		while (j < tArr.length-1) {
			if (k == -1 || tArr[k] == tArr[j]) {
				k++;
				j++;
				if (tArr[k] != tArr[j]) {
					next[j] = k;
				} else {
					next[j] = next[k];
				}
			} else {
				k = next[k];
			}
		}
		return next;
	}

}
