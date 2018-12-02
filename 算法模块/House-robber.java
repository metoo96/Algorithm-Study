/**
*
* @author Guozhu Zhu
* @date 2018/12/02
* @version 1.0
*/
class Solution {
    
    //暴力递归搜索解法
    public int search(int idx, int[] nums) {
        if (idx < 0) {
            return 0;
        }
        return Math.max(search(idx-1, nums), nums[idx]+search(idx-2, nums));
    }
    
    //DP算法
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length+1];
        f[0] = 0;
        f[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            f[i] = Math.max(nums[i-1]+f[i-2], f[i-1]);
        }
        return f[nums.length];
    }
    
}
