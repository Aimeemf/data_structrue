package leetcode;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode26Solution {
    public int removeDuplicates(int[] nums) {
        //所有不重复的元素放在[0, k)之间
        int k = 1; //初始数组第一位不重复
        for (int i = k; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]){
                nums[k] = nums[i];
                k ++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
//        输入：nums = [1,1,2]
//        输出：2, nums = [1,2,_]
//        解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素
        int[] nums = {2,2,3};
        int i = new LeetCode26Solution().removeDuplicates(nums);
        System.out.println("i = " + i);

    }
}