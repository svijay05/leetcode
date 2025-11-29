package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS {

    List<List<Integer>> adj = new ArrayList<>();


    private void dfs() {

        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[adj.size()];

        s.push(0);
        while (!s.isEmpty()) {
            int ele = s.pop();
            if (!visit[ele]) {
                visit[ele] = true;
                System.out.println(ele);
                adj.get(ele).forEach(e -> s.push(e));
            }
        }
    }


    private void bfs() {

        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[adj.size()];
        q.add(0);

        while (!q.isEmpty()) {
            int ele = q.poll();

            if (!visit[ele]) {
                visit[ele] = true;
                System.out.println(ele);
                adj.get(ele).forEach(e -> q.add(e));
            }
        }
    }


    private void bfsRecur() {
        boolean visit[] = new boolean[adj.size()];
        dfsUtil(0, visit);
    }

    private void dfsUtil(int node, boolean visit[]) {

        if (!visit[node]) {
            visit[node] = true;
            System.out.println(node);
        }

        for (int e : adj.get(node)) {
            dfsUtil(e, visit);
        }
    }

    public static void main(String[] args) {

        BFS b = new BFS();
        b.adj.add(Arrays.asList(1,2)); //0
        b.adj.add(Arrays.asList(3)); // 1
        b.adj.add(Arrays.asList(4)); //2
        b.adj.add(Arrays.asList()); //3
        b.adj.add(Arrays.asList()); //4
        //b.bfs();

        b.dfs();
        System.out.println("BFSSSS");
        b.bfs();


    }

}
