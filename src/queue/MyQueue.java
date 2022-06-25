package queue;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    //定义栈顶就是队首，出栈和入栈就会变得简单。

    //push元素则需要在栈底放一个元素
    public void push(int x) {
        Stack<Integer> stack2 = new Stack<>();
        //新创建一个栈，将stack的元素，都copy进stack2中,此时数据已逆序
        while (!stack.isEmpty()){
            stack2.push(stack.pop());
        }

        //在stack中添加新的元素
        stack.push(x);
        //再把stack2的元素放回stack
        while (!stack2.isEmpty()){
            stack.push(stack2.pop());
        }
    }
    
    public int pop() {
       return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("MyQueue: ");
        res.append('[');
        for(Integer i : stack){
            res.append(i).append(" ");
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());
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