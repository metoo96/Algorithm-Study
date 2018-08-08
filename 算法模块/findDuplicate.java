package p23;

import java.util.HashSet;
import java.util.Set;
/**
 * 寻找重复数
 * @author Guozhu Zhu
 * @date 2018/8/9
 * @version 1.0
 *
 */
public class Test04 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 4, 5};
		int ans = findDuplicate(arr);
		System.out.println(ans);
	}
	
	public static int findDuplicate(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				return arr[i];
			}
			set.add(arr[i]);
		}
		return -1;
	}

}
