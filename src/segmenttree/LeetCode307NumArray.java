package segmenttree;

class LeetCode307NumArray {

    private int[] sum;

    private int[] data;

    public LeetCode307NumArray(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

    }
    
    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        LeetCode307NumArray numArray = new LeetCode307NumArray(arr);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8

    }
}