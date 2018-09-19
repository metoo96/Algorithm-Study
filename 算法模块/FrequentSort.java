class Solution {
    
    //按字符出现频率数排序输出
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<Map.Entry<Character, Integer>>(new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < ch.length; i++) {
            if (!map.containsKey(ch[i])) {
                map.put(ch[i], 1);
            } else {
                map.put(ch[i], map.get(ch[i])+1);
            }
        }
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Map.Entry<Character, Integer> a : set) {
            queue.offer(a);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            char c = entry.getKey();
            int  num = entry.getValue();
            for (int i = 0; i < num; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
