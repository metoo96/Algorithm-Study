/**
* LRUCache
* @author Guozhu Zhu
* @date 2018/10/09
* @version 1.0
*/
class LRUCache{
    
    public LinkedHashMap<Integer, Integer> lruCache;
    
    public LRUCache(int capacity) {
        lruCache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
              protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                 return size() > capacity;
              }
        };
    }
    
    public int get(int key) {
        if (lruCache.get(key) != null) {
        return lruCache.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        lruCache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
