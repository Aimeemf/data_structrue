package sqrt;

import segmenttree.Merger;

import java.util.Arrays;

public class SQRTDecomposition<E> {
    private E[] data;
    private E[] blocks;
    private int N;  //元素总数
    private int B;  //每组元素个数
    private int Bn;     //组数
    private Merger<E> merger;   //比较器

    public SQRTDecomposition(E[] arr, Merger<E> merger){
        this.merger = merger;
        N = arr.length;
        B = (int)Math.sqrt(N);
        Bn = N / B + (N % B == 0 ? 0 : 1);
        data = Arrays.copyOf(arr, N);
        blocks = (E[])(new Object[Bn]);
        for (int i = 0; i < N; i++) {
            if(i % B == 0){
                blocks[i / B] = data[i];
            }
            blocks[i / B] = merger.merge(blocks[i / B], data[i]);
        }
    }

    //分组法求数组某个区间的最大/最小值
    public E queryRange(int left, int right){
        if(left < 0 || left >= N || right < 0 || right >= N || left > right){
            return null;
        }

        int bStart = left / B;
        int bEnd = right / B;
        E res = data[left];
        if(bStart == bEnd){
            for (int i = left + 1; i <= right; i++) {
                res = merger.merge(res, data[i]);
            }
            return res;
        }

        for (int i = left + 1; i < (bStart + 1) * B; i++) {
            res = merger.merge(res, data[i]);
        }

        for (int b = bStart + 1; b < bEnd; b++) {
            res = merger.merge(res, blocks[b]);
        }

        for (int i = bEnd * B; i <= right; i++) {
            res = merger.merge(res, data[i]);
        }
        return res;
    }

    //单元素更新
    public void update(int index, E val){
        if(index < 0 || index >= N){
            return;
        }
        int b = index / B;
        blocks[b] = merger.merge(blocks[b], val);
        data[index] = val;
    }

    public static void main(String[] args) {
        Integer[] arr = {-5, -2, -1, 0, 2, 3};
        SQRTDecomposition<Integer> decomposition = new SQRTDecomposition<Integer>(arr, (a, b) -> Math.max(a, b));
        decomposition.update(1, 6);
        System.out.println(decomposition.queryRange(0, 5));
    }
}
