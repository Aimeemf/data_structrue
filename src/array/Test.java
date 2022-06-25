package array;

import stack.ArrayStack;

public class Test {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++){
            array.addLast(i);
        }
        //System.out.println(array);
        array.add(1, 100);

        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
