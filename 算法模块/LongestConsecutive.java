/**
* @author Guozhu Zhu
* @date 2019/3/2
* @version 1.0
*
*/
class Solution {
    
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int len = 1;
        int longest = 1;
        int i = 0;
        while (i < nums.length) {
            if (i+1 < nums.length && nums[i]+1 == nums[i+1]) {
                len++;
                longest = Math.max(len, longest);
            } else if (i+1 < nums.length) {
                if (nums[i] == nums[i+1]) {
                    
                } else {
                    len = 1;
                }
            }
            i++;
        }
        return longest;
    }
    
}