package segmenttree;

class LeetCode307NumArray2 {

    private SegmentTree<Integer> segmentTree;

    public LeetCode307NumArray2(int[] nums) {
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int index, int val) {
        segmentTree.set(index, val);
    }
    
    public int sumRange(int left, int right) {
        if(segmentTree == null){
            throw new IllegalArgumentException("Segment Tree is null.");
        }
        return segmentTree.query(left, right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        LeetCode307NumArray2 numArray = new LeetCode307NumArray2(arr);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */