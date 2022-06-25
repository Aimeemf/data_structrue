package queue;

import array.Array;

public class ArrayQueue<E> implements Queue<E>{
    private Array<E> array;

    public ArrayQueue(int capacity){
       array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append("Queue: ");
        ret.append("Front [");
        for (int i = 0; i < array.getSize(); i++){
            ret.append(array.get(i));
            if(i != array.getSize() - 1){
                ret.append(",");
            }
        }
        ret.append("] tail");
        return ret.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
    }
}
