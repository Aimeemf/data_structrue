package sqrt;

import java.util.Arrays;

public class LeetCode307Solution {
    private int[] data;
    private int[] blocks;
    private int N;  //元素总数
    private int B;  //每组元素个数
    private int Bn;     //组数

    public LeetCode307Solution(int[] nums) {
        N = nums.length;
        if(N == 0){
            return;
        }
        B = (int)Math.sqrt(N);
        Bn = N / B + (N % B > 0 ? 1 : 0);
        data = Arrays.copyOf(nums, N);
        blocks = new int[Bn];
        for (int i = 0; i < N; i++) {
            blocks[i / B] += nums[i];
        }
    }

    public void update(int index, int val) {
        if(index < 0 || index >= N){
            return;
        }
        //减去旧的元素，加上新的元素
        int b = index / B;
        blocks[b] -= data[index];
        blocks[b] += val;

        data[index] = val;
    }

    public int sumRange(int left, int right) {
        if(left < 0 || left >= N || right < 0 || right >= N || left > right){
            return 0;
        }

        int bStart = left / B;
        int bEnd = right / B;
        int res = 0;
        if(bStart == bEnd){
            for (int i = left; i <= right; i++) {
                res += data[i];
            }
            return res;
        }

        for(int i = left; i < (bStart + 1) * B; i ++){
            res += data[i];
        }

        for (int b = bStart + 1; b < bEnd; b++) {
            res += blocks[b];
        }

        for (int i = bEnd * B; i <= right; i++) {
            res += data[i];
        }
        return res;
    }
}
