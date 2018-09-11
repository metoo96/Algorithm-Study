@description 堆排序算法实现
@author Guozhu Zhu
@date 2018/9/11
@version 1.0
public class HeapSort{
  /* ========== Test ========== */
  poublic static void main(String[] args) {
    int[] arr = {1, 4, 3, 5, 6};
    Sort01(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }
  
  public static void Sort01(int[] arr) {
    int len = arr.length;
    //构建大顶堆，从最后一个非根节点开始
    for (int i = Math.floor(len/2); i >= 0; i--) {
      downAdjust(arr, i, arr.length-1);
    }
    //下沉(相当于删除, 但删除元素放到数组最后
    for (int i = arr.length-1; i > 0; i--) {
      swap(arr, 0, i);
      downAdjust(arr, 0, i-1);
    }
  }
  
  public static void downAdjust(int[] arr, int parentIndex, int length) {
    int temp = arr[parentIndex];
    int childIndex = parentIndex*2+1;
    while (childIndex <= length) {
      if (childIndex+1 <= length && arr[childIndex+1] > arr[childIndex]) {
        childIndex++;
      }
      if (arr[childIndex] < temp) {
        break;
      }
      arr[parentIndex] = arr[childIndex];
      parentIndex = childIndex;
      childIndex = childIndex*2;
    }
    arr[parentIndex] = temp;
  }
  
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
}





































































