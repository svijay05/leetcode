package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import javax.xml.crypto.Data;

public class Kclosest {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> p.distance));

        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            Double distance = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
            pq.offer(new Data(p, distance));
        }

        int [][] result = new int[k][2] ;
        int i=0;
        while(k>0){
            Data d = pq.poll();
            if(d!=null) {result[i] = d.point; i++;}

        }
        return result;
    }

    public static class Data {

        int[] point;
        double distance;

        public int[] getPoints() {
            return point;
        }

        public void setPoints(int[] points) {
            this.point = points;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public Data(int[] points, double distance) {
            this.point = points;
            this.distance = distance;
        }
    }

}
