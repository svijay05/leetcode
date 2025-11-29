package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// topological sort
public class CourseSchedule2 {

    LinkedList<List<Integer>> adj = new LinkedList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Set<Integer> result = new LinkedHashSet<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            List<Integer> res = topologicalSort(i);

            if(res.contains(-1)){
                //duplicate
                return new int[]{};
            }else{
                result.addAll(res);
            }
        }



        int[] result2 = new int[result.size()];
        int i=0;
        for (int e: result) {
            result2[i]=e;
            i++;
        }
        return result2;
    }


    public List<Integer> topologicalSort(int start) {
        List<Integer> result = new LinkedList<>();
        boolean[] isVisited = new boolean[adj.size()];
        topologicalSortRecursive(start, start,isVisited, result);

        return result;
    }

    private void  topologicalSortRecursive(int start, int current, boolean[] isVisited, List<Integer> result) {

        isVisited[current] = true;
        for (int dest : adj.get(current)) {
            if (!isVisited[dest]) {
                topologicalSortRecursive(start,dest, isVisited, result);
            }else if(start == dest){
                result.add(-1);
                return;
            }
        }
        result.add(current);
    }


    public int[] findOrderLeet(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        //creating the adjlist
        for (int i = 0; i < prerequisites.length; i++) {
            int post = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(
                    pre,
                    new ArrayList<Integer>()
            );
            lst.add(post);
            adjList.put(pre, lst);

            indegree[post] += 1;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;

                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }


    public static void main(String[] args) {
        int[][] prerequisites = {{0, 1},{1,0}};
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

//        int[] r = new CourseSchedule2().findOrder(4, prerequisites2);

        int[] r = new CourseSchedule2().findOrderLeet(4, prerequisites2);

        System.out.println(r);

        for (int i = 0; i < r.length; i++) {
            System.out.print(i+"->");

        }
    }
}
