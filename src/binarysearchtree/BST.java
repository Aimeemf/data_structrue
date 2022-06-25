package binarysearchtree;

import java.util.*;

/**
 * 二分搜索树
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素E,递归算法
    //返回插入新节点后二分搜索树的根
    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            //要插入的值小于当前节点，在左子树继续寻找
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            //要插入的值大于当前节点，在右子树继续寻找
            node.right = add(node.right, e);
        }
        return node;
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    //看二分搜索树中是否包含元素e,递归算法
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索数的前序遍历(先根节点，再左子树，再右子树)
    public void preOrder(){
        preOrder(root);
    }

    //二分搜索数的前序遍历,递归算法
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索数的非递归前序遍历(先根节点，再左子树，再右子树)
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //二分搜索数的中序遍历(先左子树，再根节点，再右子树),有序
    public void inOrder(){
        inOrder(root);
    }

    //二分搜索数的中序遍历,递归算法
    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索数的后序遍历(先左子树，再右子树，再根节点)
    public void postOrder(){
        postOrder(root);
    }

    //二分搜索数的后序遍历,递归算法
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历（广度优先遍历）
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    //寻找二分搜索树的最小元素,递归算法
    public Node minimum(Node node){
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    //寻找二分搜索树的最大元素,递归算法
    public Node maximum(Node node){
        if(node.right == null){
            return node;
        }

        return maximum(node.right);
    }

    //从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
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

    //从二分搜索树中删除最大值所在的节点，返回最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node nodeLeft = node.left;
            node.left = null;
            size --;
            return nodeLeft;
        }

        node.right = removeMin(node.right);
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    //删除以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后的新的二分搜索树的根
    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
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

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++){
            res.append("==");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        Random random = new Random();
//        int n = 1000;
//        for(int i = 0; i < n; i++){
//            bst.add(random.nextInt(10000));
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        while (!bst.isEmpty()){
//            list.add(bst.removeMin());
//        }
//        System.out.println(list);
//        for (int i = 1; i < list.size(); i++){
//            if(list.get(i) < list.get(i-1)){
//                throw new IllegalArgumentException("Error");
//            }
//        }
//        System.out.println("removeMin test completed.");

        int[] nums = {41, 58, 50, 60, 42, 53, 59, 63};
        for (int num : nums) {
            bst.add(num);
        }
        bst.remove(58);
//        bst.preOrder();

//        System.out.println();

//        bst.levelOrder();

//        System.out.println(bst);

//        bst.inOrder();

//        bst.postOrder();

//        System.out.println(bst.minimum());
//        System.out.println(bst.maximum());

//        bst.removeMin();

    }
}
