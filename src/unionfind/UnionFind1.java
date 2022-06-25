package unionfind;

public class UnionFind1 implements UF{
    private int[] id;

    public UnionFind1(int size){
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
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
        if(p < 0 || p >= id.length || q < 0 || q >= id.length){
            throw new IllegalArgumentException("p or q is out of bound.");
        }

        int pId = find(p);
        int qId = find(q);
        if(pId == qId){
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if(id[i] == pId){
                id[i] = qId;
            }
        }
    }

    //查找元素p所对应的集合编号
    private int find(int p){
        if(p < 0 || p >= id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
