package countingsort;

class LeetCode75Solution {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]] ++;
        }

        for (int i = 0; i < cnt[0]; i++){
             nums[i] = 0;
        }
        for (int i = cnt[0]; i < cnt[0] + cnt[1]; i++){
            nums[i] = 1;
        }
        for (int i = cnt[0] + cnt[1]; i < cnt[0] + cnt[1] + cnt[2]; i++){
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,1,0};
        new LeetCode75Solution().sortColors(arr);
    }
}