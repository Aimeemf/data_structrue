package leetcode;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode167Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j){
            if(numbers[i] + numbers[j] > target){
                j --;
            }else if(numbers[i] + numbers[j] < target){
                i ++;
            }else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[0];
    }

    public int[] twoSum1(int[] numbers, int target) {
        //二分搜索法，当前数据是i,在[i+1,numbers.length-1]中查找target - i;
        int r = numbers.length - 1;
        for (int i = 0; i < r; i++) {
            int l = i + 1;
            while (l <= r){
                int num = target - numbers[i];
                int mid = (l + r) / 2;
                if(num < numbers[mid]){
                    r = mid - 1;
                }else if(num > numbers[mid]){
                    l = mid + 1;
                }else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
//        输入：numbers = [2,7,11,15], target = 9
//        输出：[1,2]
//        解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
        int[] numbers = {2, 3, 4};
        int[] ints = new LeetCode167Solution().twoSum1(numbers, 6);
        System.out.println();
    }
}