package p39;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 前k个高频元素
 * @author Guozhu Zhu
 * @date 2018/9/15
 * @version 1.0
 *
 */
public class Test04 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 2, 3, 3, 3};
		List<Integer> list = Solution(arr, 2);
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static ArrayList<Integer> Solution(int[] nums, int k){
        ArrayList<Integer> resList = new ArrayList<Integer>();
		//大顶堆
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}
		});
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		for (Map.Entry<Integer, Integer> j : set) {
			maxHeap.offer(j);
		}
		for (int i = 0; i < k; i++) {
			resList.add(maxHeap.poll().getKey());
		}
		return resList;
	}

}
