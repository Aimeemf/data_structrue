package stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int ret = 0;
        //创建另外一个队列
        Queue<Integer> queue2 = new LinkedList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++){
            //除了最后一个元素，将queue的其余元素放到另外一个队列
            if(i < size - 1) {
                queue2.add(queue.remove());
            }else {
                //queue中剩下的最后一个元素就是栈顶元素
                ret = queue.remove();
            }
        }
        //此时的queue2中存放的是queue中的其他元素，赋值给queue
        queue = queue2;
        return ret;
    }

    public int top() {
        //使用pop将栈顶元素取出记录，因为top不会删除元素值，再放回去就好了
        int ret = pop();
        queue.add(ret);
        return ret;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("MyStack: ");
        res.append('[');
        for(Integer i : queue){
            res.append(i).append(" ");
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
