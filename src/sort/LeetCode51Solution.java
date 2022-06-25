package sort;

class LeetCode51Solution {
    public int reversePairs(int[] nums) {
         return sort(nums);
    }

    public int sort(int[] nums){
       return sort(nums, 0, nums.length - 1);
    }

    public int sort(int[] nums, int l, int r){
        if(l >= r){
            return 0;
        }

        int mid = l + (r - l) / 2;
        return sort(nums, l, mid) + sort(nums, mid + 1, r) + merge(nums, l, mid, r);
    }

    public int merge(int[] nums, int l, int mid, int r){
        int[] help = new int[r-l+1];
        int p1 = l, p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= r){
            res += nums[p1] > nums[p2] ? (mid - p1 + 1) : 0;
            help[i++] = nums[p1] > nums[p2] ? nums[p2++] : nums[p1++];
        }

        while (p1 <= mid){
            help[i++] = nums[p1++];
        }

        while (p2 <= r){
            help[i++] = nums[p2++];
        }

        for (i = 0; i < help.length; i++){
            nums[l+i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2 ,3, 1};
        System.out.println(new LeetCode51Solution().reversePairs(nums));
    }
}