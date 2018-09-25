/**
* 优先级队列的实现
* @author Guozhu Zhu
* @date 2018/9/25
* @version 1.0
*
*/
public class PriorityQueue{
    
    private int[] array;
    
    private int size;
    
    public PriorityQueue(){
        this(10)
    }
    
    public PriorityQueue(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }
    
    //1. offer elements
    public void offer(int e){
        if (this.size >= this.array.length){
             resize();
        }
        this.array[this.size++] = e;
        upAdjust();
    }
    
    //2. poll elements
    public void poll(){
        if (this.size <= 0) {
            throw new Exception("Heap is empty");
        }
        int temp = this.array[0];
        this.array[0] = this.array[this.size-1];
        downAdjust();
        return temp;
    }  

    //3. resize
    public void resize() {
        int[] newData = new int[this.size*2];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.array[i];
        }
        this.array = newData;
    }
    
    //4. downAdjust
    public void downAdjust(){
        int childIndex = this.size-1;
        int temp = this.array[childIndex];
        int parentIndex = childIndex / 2;
        while (childIndex > 0 && temp > this.array[parentIndex]) {
             this.array[childIndex] = this.array[parentIndex];
             childIndex = parentIndex;
             parentIndex = parentIndex / 2;
        }
        this.array[childIndex] = temp;
    }
    
    //5. upAdjust
    public void upAdjust() {
       int parentIndex = 0;
       int temp = this.array[parentIndex];
       int childIndex = parentIndex*2+1;
       while (childIndex < this.size) {
            if (childIndex+1 < this.size && this.array[childIndex+1] > this.array[childIndex]) {
                 childIndex++;
               }
            if ( temp > this.array[parentIndex]) {
                 break;
            }
            this.array[parentIndex] = this.array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex*2;
      }
      this.array[parentIndex] = temp;
    }
    
    /* ========== Test ========== */
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
            queue.offer(1);
    }

}   
