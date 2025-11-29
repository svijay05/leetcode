package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

    LinkedList<List<Integer>> adj = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            boolean res = dfs(i);
            if (res == true) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int v) {

        if (visited.contains(v)) {
            return true;
        }
        if (adj.get(v).isEmpty()) {
            return false;
        }

        visited.add(v);
        for (int neighbor : adj.get(v)) {
            boolean res = dfs(neighbor);
            if (res == true) {
                return true;
            }
        }
        System.out.println(v);
        visited.remove(v);
        //adj.set(v, new ArrayList<>());

        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}};
        boolean result = new CourseSchedule().canFinish(2, prerequisites);
        System.out.println(result);
    }
}
