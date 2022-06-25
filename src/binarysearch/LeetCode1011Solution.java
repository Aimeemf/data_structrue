package binarysearch;

import java.util.Arrays;

class LeetCode1011Solution {
    public int shipWithinDays(int[] weights, int days) {
        //最小的装载量
        int l = Arrays.stream(weights).max().getAsInt();

        //最大的装载量
        int r = Arrays.stream(weights).sum();

        while (l < r){
            int mid = l + (r - l) / 2;
            if(getDaysWithMaxWeight(weights, mid) <= days){
                r = mid;
            }else {
                l = mid + 1;
            }

        }
        return l;
    }

    //根据船的最大运载重量，计算几天可以运完
    private int getDaysWithMaxWeight(int[] weights, int maxWeight){
        int days = 0;
        int sum = 0;
        for(int i = 0; i < weights.length; i ++){
            sum += weights[i];
            if(sum > maxWeight){
                sum = weights[i];
                days += 1;
            }
        }
        return days + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1};
        System.out.println(new LeetCode1011Solution().shipWithinDays(arr, 4));
    }

}