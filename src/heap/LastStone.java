package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone {

    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    public int lastStoneWeight(int[] stones) {


        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() >= 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (y != x) {
                pq.offer(y - x);
            }
        }
        Integer lastE = pq.poll();
        return lastE == null ? 0 : lastE;

    }

}
