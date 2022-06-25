package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode447Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            //存储点到i的距离，和频次
            HashMap<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(j != i){
                    int dis = dis(points[i], points[j]);
                    if(!record.containsKey(dis)){
                        record.put(dis, 1);
                    }else {
                        record.put(dis, record.get(dis) + 1);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
                Integer d = entry.getValue();
                res += d * (d - 1);
            }
        }
        return res;
    }

    private int dis(int[] pa, int[] pb) {
        return (pb[0] - pa[0]) * (pb[0] - pa[0]) + (pb[1] - pa[1]) * (pb[1] - pa[1]);
    }

    public static void main(String[] args) {
//        输入：points = [[1,1],[2,2],[3,3]]
//        输出：2
    }
}