class MinStack {
    
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    /** initialize your data structure here. */
    Integer temp = null;
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (temp != null) {
            if (temp > x) {
                temp = x;
                min.push(x);
            }
            data.push(x);
        } else {
            temp = x;
            data.push(x);
            min.push(x);
        }
    }
    
    public void pop() {
      int num1 = data.pop();
      int num2 = min.pop();
      if (num1 != num2) {
          min.push(num2);
      }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        if (min != null) {
        return min.peek();
        } else {
            return 0;
        }
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */