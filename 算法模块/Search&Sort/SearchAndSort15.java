/**
* @author Guozhu Zhu
* @date 2018/8/27
* @version 1.0
*
*/
public class Test01 {

    public static void Sort01(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j+1] < arr[j]) {
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                }
            }
        }
    }
    
    public static void Sort02(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                }
            }
        }
    }
    
    public static void Sort03(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low = 0;
            int high = i-1;
            int mid = 0;
            while (low <= high) {
                mid = (low+high) / 2;
                if (arr[mid] > temp) {
                    high = mid-1;
                  } else {
                    low = mid+1;
                  }
             }
             for (int j = i-1; j >= low; j--) {
                 arr[j+1] = arr[j];
             }
             arr[low] = temp;
   }
   
   public static void Sort04(int[] arr) {
       for (int i = 1; i < arr.length; i++) {
           int temp = arr[i];
           int j = i-1;
           while (j >= 0 && arr[j] > temp) {
               arr[j+1] = arr[j];
               j--;
           }
           arr[j+1] = temp;
   }
   
   public static void Sort05(int[] arr, int left, int right) {
       if (left > right) {
           return -1;
       }
       int i = left;
       int j = right;
       int key = arr[i];
       while (i < j) {
           while (i < j && arr[j] > key) {
               j--;
               }
               arr[i] = arr[j];
           while (i < j && arr[i] < key) {
               i++;
               }
               arr[j] = arr[i];
       }
       arr[i] = key;
       Sort05(arr, left, mid-1);
       Sort05(arr, mid+1, right);
   }
   
   public static int search01(int[] arr, int target) {
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] == target) {
               return i;
           }
       }
       return -1;
   }
   
   public static int search02(int[] arr, int target, int left, int right) {
       if (left > right) {
           return -1;
       }
       int mid = (left+right) / 2;
       if (arr[mid] > target) {
           return search02(arr, target, left, mid-1)'
       } else if (arr[mid] < target) {
          return search02(arr, target, mid+1, right);
       } else {
          return mid;
       }
   }
   
}
