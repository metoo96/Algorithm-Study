/**
* 前k个高频单词
* @Guozhu Zhu
* @date 2018/9/15
* @version  1.0
*
*/
class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> resList = new ArrayList<String>();
        //构建大顶堆
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return (o1.getKey()).compareTo(o2.getKey());
                }
            }
        });
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i])+1);
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> j : set) {
            maxHeap.offer(j);
        }
        for (int i = 0; i < k; i++) {
            resList.add(maxHeap.poll().getKey());
        }
        return resList;    
    }
    
}
