package sort;

class LeetCode75Solution {
    public void sortColors(int[] nums) {
        int lt = -1;
        int i = 0;
        int gt = nums.length;
        while (i < gt){
            if(nums[i] == 0){
                lt ++;
                swap(nums, i, lt);
                i ++;
            }else if(nums[i] == 1){
                i ++;
            }else {
                gt --;
                swap(nums, i, gt);
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new LeetCode75Solution().sortColors(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ",");
        }
    }
}