package p40;

/**
 * 最长公共子序列
 * @author Guozhu Zhu
 * @date 2018/12/10
 * @version 1.0
 *
 */
public class Test07 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		String str1 = "fpyidsh332xwh";
		String str2 = "mwecd4443qupal";
		int res1 = lcs(str1, str2);
		System.out.println(res1);
		int res2 = lcs1(str1, str2);
		System.out.println(res2);
	}
	
	//最长公共子序列
	public static int lcs(String str1, String str2) {
	    int len1 = str1.length();
	    int len2 = str2.length();
	    int c[][] = new int[len1+1][len2+1];
	    for (int i = 0; i <= len1; i++) {
	        for( int j = 0; j <= len2; j++) {
	            if(i == 0 || j == 0) {
	                c[i][j] = 0;
	            } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
	                c[i][j] = c[i-1][j-1] + 1;
	            } else {
	                c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
	            }
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i <= len1; i++) {
	    	for (int j = 0; j <= len2; j++) {
	    		System.out.print(c[i][j]);
	    	}
	    	System.out.println("");
	    }
	    int i = len1-1;
	    int j = len2-1;
	    while (i > 0 && j >  0) {
	    	if (str1.charAt(i) == str2.charAt(j)) {
	    		sb.append(str1.charAt(i));
	    		i--;
	    		j--;
	    	} else if (c[i-1][j] >= c[i][j-1]) {
	    		i--;
	    	} else {
	    		j--;
	    	}
	    }
	    System.out.println(sb.toString());
	    return c[len1][len2];
	}
	
	//最长公共子串
	public static int lcs1(String str1, String str2) {
	    int len1 = str1.length();
	    int len2 = str2.length();
	    int result = 0;     //记录最长公共子串长度
	    int c[][] = new int[len1+1][len2+1];
	    for (int i = 0; i <= len1; i++) {
	        for( int j = 0; j <= len2; j++) {
	            if(i == 0 || j == 0) {
	                c[i][j] = 0;
	            } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
	                c[i][j] = c[i-1][j-1] + 1;
	                result = Math.max(c[i][j], result);
	            } else {
	                c[i][j] = 0;
	            }
	        }
	    }
	    return result;
	}



}
