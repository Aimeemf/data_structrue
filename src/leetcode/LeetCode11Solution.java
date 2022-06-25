package leetcode;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode11Solution {
    public int maxArea(int[] height) {
        //双指针法求解，容器的容积v = Math.Min(l, r) * (r - l), 每次移动指针时, (r - l)会变小，
        //而容积要大，因此Math.Min(l, r)要尽可能的大，因此我们每次移动值比较小的指针
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r){
            maxArea = Math.max(maxArea, getArea(height, l, r));
            if(height[l] < height[r]){
                l ++;
            }else {
                r --;
            }
        }
        return maxArea;
    }

    public int getArea(int[] height, int l, int r) {
       return Math.min(height[l], height[r]) * (r - l);
    }
}