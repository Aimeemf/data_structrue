package linkedlist;

import javafx.util.Pair;

public class LinkedListR<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedListR(){
        head = null;
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在索引为index的位置添加新的元素e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }

       head = add(head, index, e);
       size ++;
    }

    //在以node为头结点的链表的index位置，插入元素e, 递归算法
    private Node add(Node node, int index, E e){
        if(index == 0){
            return new Node(e, node);
        }

        node.next = add(node.next, index - 1, e);
        return node;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
        add(0, e);
    }

    //在链表末尾添加元素e
    public void addLast(E e){
        add(size, e);
    }

    //在链表中获取第index的元素
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }

        return get(head, index);
    }

    //在以node为头结点的链表中，找到第index个元素，递归算法
    public E get(Node node, int index){
        if(index == 0){
            return node.e;
        }
        return get(node.next, index -1);
    }

    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //修改链表中的第index个元素
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        set(head, index, e);
    }

    //修改链表中的第index个元素,递归算法
    public void set(Node node, int index, E e){
        if(index == 0){
            node.e = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        return contains(head, e);
    }

    //查找链表中是否有元素e,递归算法
    public boolean contains(Node node, E e){
        if (node == null){
            return false;
        }

        if(node.e == e){
            return true;
        }
        return contains(node.next, e);
    }

    //从链表中删除index位置的元素
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        Pair<Node, E> res = remove(head, index);
        size --;
        head = res.getKey();
        return res.getValue();
    }


    //从链表中删除index位置的元素,递归实现
    public Pair<Node,E> remove(Node node, int index){
        if(index == 0){
            return new Pair<>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    //从链表中删除第一位的元素
    public E removeFirst(){
        return remove(0);
    }

    //从链表中删除最后一位的元素
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListR<Integer> linkedList = new LinkedListR<>();
        for (int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
