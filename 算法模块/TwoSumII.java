/**
* 两数之和等于目标值
* @author Guozhu Zhu
* @date 2018/10/09
* @version 1.0
*/
class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);    //K: 为数组的值， V: 数组的下标；
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target-nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }
    
}
