package maxheap;

import array.Array;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i >= 0; i --){
            siftDown(i);
        }
    }

    //返回堆中元素个数
    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //看堆中的最大元素
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("can not findMax when heap is empty.");
        }
        return data.get(0);
    }
    //取出堆中最大的元素
    public E extractMax(){
        E ret = findMax();
        //将0位置和数组最后一位元素交换
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j ++;
            }
            if(data.get(k).compareTo(data.get(j)) >= 0) {
               break;
            }else {
                data.swap(k, j);
                k = j;
            }
        }
    }

    //取出堆中最大元素，并替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
//        int n = 1000000;
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//
//        for (int i = 1; i < n; i++) {
//            if(arr[i - 1] < arr[i]){
//                throw new IllegalArgumentException("Error");
//            }
//        }
//
//        System.out.println("Test MaxHeap completed.");

        Integer[] arr = {2, 23, 67, 76, 8, 19};
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
    }
}
