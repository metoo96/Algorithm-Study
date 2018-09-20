/**
* 合并两个有序数组（其实就是用到了归并排序中的归并步骤的部分代码)
* @author Guozhu Zhu
* @date 2018/9/20
* @version 1.0
*
*/
class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[m+n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }
        for (int  a = 0; a < k; a++) {
            nums1[a] = temp[a];
        }
    }
    
}
