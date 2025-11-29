package heap;

import java.security.KeyPair;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int time=0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->Integer.compare(y,x));
        Queue<Task> q = new LinkedList<>();
        int[] tn = new int[26];

        for (int i = 0; i < tasks.length ; i++) {
          tn[tasks[i] - 'A']++;
        }

        for (int i = 0; i < tn.length ; i++) {
          if(tn[i]!=0)  pq.offer(tn[i]);
            //System.out.println(tn[i]);
        }

        while(!pq.isEmpty() || !q.isEmpty()){



            Integer val = pq.poll();
            if(val!=null && val>0){
                val--;
                time++; // task  time
               if(val>0) q.add(new Task(val, (time+n)));
            }
            else{
                time++; //idle time
            }
            System.out.println(time);



            Task t = q.peek();
            if(t!=null && t.waitTime == time){
                pq.offer(t.count);
                q.poll();
            }


        }

      return time;
    }

     static class Task {

        int count;
        int waitTime;

        public Task(int count, int waitTime) {
            this.count = count;
            this.waitTime = waitTime;
        }


    }

    public static void main(String[] args) {
        System.out.println( leastInterval(new char[]{'A','A','A','B','B','B'},0) );
    }




}
