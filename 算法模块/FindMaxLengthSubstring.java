package p40;

/**
 * 最长公共子序列
 * @author Guozhu Zhu
 * @date 2018/9/17
 * @version 1.0
 *
 */
public class Test06 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		String str1 = "fpyidshxwh";
		String str2 = "mwecdqupal";
		String res = "wpqb";
		solution(str1, str2);
	}
	
	public static void solution(String str1, String str2) {
		int[][] opt = new int[str1.length()+1][str2.length()+1];
		for (int i = str1.length()-1; i >= 0; i--) {
			for (int j = str2.length()-1; j >= 0; j--) {
				if (str1.charAt(i) == str2.charAt(j)) {
					opt[i][j] = opt[i+1][j+1] + 1;
				} else {
					opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
				}
			}
		}
		for (int i = 0; i < opt.length; i++) {
			for (int j = 0; j < opt[0].length; j++) {
				System.out.print(opt[i][j]);
			}
			System.out.println("");
		}
		System.out.println(str1);
		System.out.println(str2);
	    int i = 0;
	    int j = 0;
	    while (i < str1.length() && j < str2.length()) {
	    	if (str1.charAt(i) == str2.charAt(j)) {
	    		System.out.print(str1.charAt(i));
	    		i++;
	    		j++;
	    	} else if (opt[i+1][j] > opt[i][j+1]) {
	    		i++;
	    	} else {
	    		j++;
	    	}
	    }
	}

}
