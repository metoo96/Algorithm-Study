package p35;

/**
 * KMP模式匹配算法实现
 * @author Guozhu Zhu
 * @date 2018/9/6
 * @version 1.0
 *
 */
public class Test06 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		char[] in = {'g', 'u'};
		int[] ans = getNext(in);
		int res = KmpMatches("zhuguozhu", "gu", ans);
		System.out.println(res);
	}
	
	public static int KmpMatches(String S, String T, int[] next) {
		char[] sArr = S.toCharArray();
		char[] tArr = T.toCharArray();
		if (sArr.length <= 0 || tArr.length <= 0) {
			return -1;
		}
		int i = 0;
		int j = 0;
		while (i < sArr.length && j < tArr.length) {
			//j = -1时的情况是不匹配跳转过来的， next[0]是-1， 其他是不可能出现-1的next[i]
			//即模式串T第一个匹配失败时
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
	
	//获取模式串的数组, 优化版(主要解决之前的类似abba这种对称性的优化策略)
	public static int[] getNext(char[] T) {
		int[] next = new int[T.length];
		next[0] = -1;
		int j = 0;
		int k =-1;
		while (j < next.length-1) {
			if (k == -1 || T[k] == next[j]) {
				j++;
				k++;
				if (T[k] != next[j]) {
				    next[j] = k;
				} else {
					next[j] = next[k];
				}
			} else {
				k = next[j];
			}
		}
		return next;	
	}

}
