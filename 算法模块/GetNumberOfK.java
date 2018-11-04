public class Solution {
    
    public int GetNumberOfK(int [] array , int k) {
       if (array == null || array.length == 0) {
           return 0;
       }
       int firstK = getFirstK(array, k);
       int lastK = getLastK(array, k);
       if (firstK != -1 && lastK != -1) {
           return lastK-firstK+1;
       }
       return 0;
    }
    
    public int getFirstK(int[] array, int k) {
       int low = 0;
       int high = array.length-1;
       int mid = 0;
       while (low <= high) {
           mid = (low+high) / 2;
           if (array[mid] > k) {
               high = mid-1;
           } else if (array[mid] < k) {
               low = mid+1;
           } else if (mid-1 >= 0 && array[mid-1] == k) {
               high = mid-1;
           } else {
               return mid;
           }
       }
       return -1;
    }
    
    public int getLastK(int[] array, int k) {
        int low = 0;
        int high = array.length-1;
        int mid = 0;
        while (low <= high) {
            mid = (low+high) / 2;
            if (array[mid] > k) {
                high = mid-1;
            } else if (array[mid] < k) {
                low = mid+1;
            } else if (mid+1 < array.length && array[mid+1] == k) {
                low = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
}