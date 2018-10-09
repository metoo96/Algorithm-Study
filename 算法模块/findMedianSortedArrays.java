/**
* 两个排序数组的中位数
* @author Guozhu Zhu
* @date 2018/10/09
* @version 1.0
*/
class Solution {
    
    //采用了归并的思想
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int m = nums1.length-1;
        int n = nums2.length-1;
        int k = 0;
        while (i <= m && j <= n) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i <= m) {
            temp[k++] = nums1[i++];
        }
        while (j <= n) {
            temp[k++] = nums2[j++];
        }
        //处理偶数个元素时
        if (k%2 == 0) {
            return (temp[(k/2-1)]+temp[k/2]) / 2.0;
        }
        return temp[k/2];
    }
    
}
