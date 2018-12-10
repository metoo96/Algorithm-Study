/**

* 最长上升子序列
* @author Guozhu Zhu
* @date 2018/12/10
* @version 1.0 
*/
class Solution {
    
    public int lengthOfLIS(int[] arr) { 
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
	int lis = 0;
	for (int i = 0; i < arr.length; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
		if (arr[i] > arr[j] && dp[i] < dp[j]+1) {
			dp[i] = dp[j]+1;
		}
            }
	}
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] > lis) 
                lis = dp[i];
        }
	return lis;
    }
    
}
