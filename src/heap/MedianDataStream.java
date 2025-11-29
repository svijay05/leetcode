package heap;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianDataStream {

// 1 2 3 4 5

    private PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    ; // max-heap
    private PriorityQueue<Integer> hi = new PriorityQueue<>(); // min-heap

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 4,5 to store larger element
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 3 2 1 to store smaller ele

    public MedianDataStream() {

    }

    public void addNum(int num) {

        // Hammeeeeyyyyy adaaar

        Deque<Integer> q = new LinkedList<>();

        lo.offer(num); // Add to max-heap
        hi.offer(lo.poll()); // balancing step
        if (lo.size() < hi.size()) { // maintain size property
            lo.offer(hi.poll());
        }

    }

    public double findMedian() {

        if (lo.size() > hi.size()) {
            return lo.peek();
        } else {
            return (lo.peek() + hi.peek()) * 0.5;
        }

    }

    public static void main(String[] args) {
        MedianDataStream mds = new MedianDataStream();

        mds.addNum(1);
        mds.addNum(2);
        System.out.println(mds.findMedian());

        mds.addNum(3);
        System.out.println(mds.findMedian());
    }

}
