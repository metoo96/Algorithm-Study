/*
* @author Guozhu Zhu
* @date 2018/9/20
* @version 1.0
*
*/
class Solution {
    
    public int removeDuplicates(int[] nums) {
        int repeat = 2;
        if(nums.length <= repeat)
            return nums.length;
        int len2 = 1;
        int cnt = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[len2-1]) {
                cnt = 1;
                nums[len2++] = nums[i];
            } else {
                cnt++;
                if (cnt > repeat) {
                    continue;
                } else {
                    nums[len2++]  = nums[i];
                }
            }
        }
        return len2;
    }
    
}
