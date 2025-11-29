package slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < k + i && j < nums.length) {
                max = Math.max(nums[j], max);
                j++;
            }

            if (j == k + i) {
                list.add(max);
                max = Integer.MIN_VALUE;
            }

        }

        //list.forEach(e -> System.out.println(e));
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }


    public int[] maxSlidingWindowDeqeue(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // storing not the element only element index

            if (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst(); // if window full
            }
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast(); // keep only largest element (size always 1)
            }
            q.offer(i);
            if (i >= k - 1) {
                ans[j++] = nums[q.peekFirst()]; // add answer, post k value each move is a value update
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] res = new SlidingWindowMaximum().maxSlidingWindowDeqeue(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);

        for (int i = 0; i < res.length; i++) {

            System.out.println(res[i]);

        }

    }
}
