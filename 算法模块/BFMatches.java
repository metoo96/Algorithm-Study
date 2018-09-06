package p35;

/**
 * 朴素的字符串模式匹配算法
 * @author Guozhu Zhu
 * @date 2018/9/2
 * @version 1.0
 *
 */
public class Test05 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int ans = BFMatches("zhuguozhu", "gu");
		System.out.println(ans);
	}
	
	//朴素的模式匹配算法(暴力破解) O(n）=n^2;
	public static int BFMatches(String S, String T) {
		char[] sArr = S.toCharArray();
		char[] tArr = T.toCharArray();
		if (sArr.length <= 0 || tArr.length <= 0) {
			return -1;
		}
		int i = 0;
		int j = 0;
		while (i < sArr.length && j < tArr.length) {
			if (sArr[i] == tArr[j]) {
				i++;
				j++;
			} else {
				i = i-j+1; //进行回溯
				j = 0;
			}
		}
		if (j >= tArr.length) {
			return i-tArr.length;
		}
		return -1;
	}

}
