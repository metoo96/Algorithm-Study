class Solution {
    
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while (nums[low] >= nums[high]) {
            if (high-low == 1) {
                mid = high;
                return nums[mid];
            }
            //如果存在重复， 则采用顺序查找；
            if (nums[low] == nums[mid] || nums[high] == nums[mid]) {
                return solution(nums);
            }
            if (nums[mid] >= nums[low]) {
                low = mid;
            }
            if (nums[mid] <= nums[high]) {
                high = mid;
            }
        }
        return nums[mid];
    }
    
    //顺序查找
    public int solution(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }
    
}