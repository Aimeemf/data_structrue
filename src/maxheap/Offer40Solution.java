package maxheap;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Offer40Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < k; i++){
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i ++){
            if(!pq.isEmpty() && arr[i] < pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = pq.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Offer40Solution().getLeastNumbers(arr, 2);
    }
}