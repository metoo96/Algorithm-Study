/**
* 寻找排序数组中心索引
* @author Guozhu Zhu
* @date 2018/9/28
* @version 1.0
*
*/
class Solution {
    
    public int pivotIndex(int[] nums) {
        if (nums.length < 2 ) {
            return -1;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftSum = 0; //单独特殊考虑 leftSum = 0;
            } else {
                leftSum += nums[i-1];
            }
            rightSum = sum - leftSum - nums[i];
             if (leftSum == rightSum) {
                return i;
             }
        }
        return -1;
    }
    
}
