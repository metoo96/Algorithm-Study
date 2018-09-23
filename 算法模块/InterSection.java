/**
* 暴力求解两个数组的交集(即不用HashSet的算法)
* @author Guozhu Zhu
* @date 2018/9/23
* @version 1.0
*
*/
class Solution {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    resList.add(nums1[i]);
                }
            }
        }  
        Integer[] resArr = (Integer[])resList.toArray(new Integer[0]);
        int[] arr = new int[resArr.length];
        for (int i = 0; i < resArr.length; i++) {
            arr[i] = resArr[i];
        
        }
        //排序
        Arrays.sort(arr);
        int len = solution(arr);
        int[] arr1 = new int[len];
        for (int i = 0; i < len; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }
    
    //删除排序数组的重复项
    public int solution(int[] array) {
     if (array == null || array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return 1;
        } else {
            int len = 0;
            for (int i = 1; i < array.length; i++) {
                if (array[i-1] != array[i]) {
                    len++;
                    array[len] = array[i];
                }
            }
            return len+1;
        }
    }
    
}
