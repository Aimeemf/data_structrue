package unionfind;

/**
 * 创建一个由孩子指向父亲的树
 */
public class UnionFind4 implements UF{
    private int[] parent;
    private int[] rank;  //rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    //查看元素p和元素q是否属于同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合
    @Override
    public void unionElements(int p, int q) {
        if(p < 0 || p >= parent.length || q < 0 || q >= parent.length){
            throw new IllegalArgumentException("p or q is out of bound.");
        }

        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }

        //让低的指向高的
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;          //p指向q
        }else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;          //q指向p
        }else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

    //查找元素p所对应的集合编号
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

}
