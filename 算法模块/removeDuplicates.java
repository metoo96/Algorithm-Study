package p23;

/**
 * 排序数组中删除重复项
 * @author Guozhu Zhu
 * @date 2018/8/8
 * @version 1.0
 *
 */
public class Test03 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 4, 5};
		int len = delete(arr);
	    for (int i = 0; i < len; i++) {
	    	System.out.println(arr[i]);
	    }
	}
	
	//算法过程
	public static int delete(int[] arr) {
		int i = 0;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}
		return i+1;
	}

}
