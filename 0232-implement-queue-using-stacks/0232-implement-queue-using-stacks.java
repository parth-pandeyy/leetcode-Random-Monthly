class MyQueue {

        Stack<Integer> Input = new Stack<>();
        Stack<Integer> Output = new Stack<>();
    
    public void push(int x) {
       Input.push(x);
    }
    
    public int pop() {
        peek();
        return Output.pop();
    }
    
    public int peek() {
        if(Output.empty()){
            while(!Input.empty()){
                Output.push(Input.pop());
            }
        }
       return Output.peek();
    }
    
    public boolean empty() {
       return Input.empty() && Output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */