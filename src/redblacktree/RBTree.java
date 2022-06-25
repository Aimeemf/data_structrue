package redblacktree;

import map.Map;

public class RBTree<K extends Comparable<K>, V> implements Map<K, V> {
    private static final Boolean RED = true;
    private static final Boolean BLACK = false;
    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;

    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    private Node leftRotate(Node node){
        Node x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    private Node rightRotate(Node node){
        Node x = node.left;
        Node t = x.right;
        //右旋转
        node.left = t;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }


    //颜色翻转
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }

    //向以node为根的二分搜索树中插入元素E,递归算法
    //返回插入新节点后二分搜索树的根
    public Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            //要插入的值小于当前节点，在左子树继续寻找
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            //要插入的值大于当前节点，在右子树继续寻找
            node.right = add(node.right, key, value);
        }else {
            node.value = value;
        }

        if(isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }

        if(isRed(node.left) && isRed(node.left.left)){
            node = rightRotate(node);
        }

        if(isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    //删除以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后的新的二分搜索树的根
    private Node remove(Node node, K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }else {
            if(node.left == null){
                Node nodeRight = node.right;
                node.right = null;
                size --;
                return nodeRight;
            }

            if(node.right == null){
                Node nodeLeft = node.left;
                node.left = null;
                size --;
                return nodeLeft;
            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点替代待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    //寻找二分搜索树的最小元素,递归算法
    public Node minimum(Node node){
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node nodeRight = node.right;
            node.right = null;
            size --;
            return nodeRight;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + "doesn't exist!");
        }

        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isRed(Node node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }

    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else if(key.compareTo(node.key) > 0){
            return getNode(node.right, key);
        }else {
            return node;
        }
    }

    public static void main(String[] args) {
        String s = "wedcderriugwiwyfcaseexawsccaaaaoo";
        RBTree<Character, Integer> map = new RBTree<>();
        for (int i = 0; i < s.length(); i ++){
            if(!map.contains(s.charAt(i))){
                map.add(s.charAt(i), 1);
            }else {
                map.set(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        System.out.println(map.size);
        System.out.println(map.get('w'));
    }
}
