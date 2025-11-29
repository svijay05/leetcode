package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Subset2 {


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        Stack<Integer> subset = new Stack<>();
        dfs2(0, nums, res, subset);
        return res;
    }


    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // DO NOT INCREMENT I TO USE SAME VALUE MULTIPLE TIMES
            backtrack(candidates, target - candidates[i], i, current, result); // Not i+1 because we can reuse the same element
            current.remove(current.size() - 1); // Backtrack
        }
    }

    private static void dfs(int i, int[] nums, List<List<Integer>> res, Stack<Integer> subset) {

        if (i >= nums.length) {
            System.out.println("Stored ->" + subset);
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.push(nums[i]);
        System.out.println("frame push ->" + (i + 1) + " -> " + subset);
        dfs(i + 1, nums, res, subset);

        subset.pop();
        System.out.println("frame pop ->" + (i + 1) + " -> " + subset);
        dfs(i + 1, nums, res, subset);
    }

    private static void dfs2(int start, int[] nums, List<List<Integer>> res, Stack<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            //System.out.println("i-> "+ i + "  Start ->" + start);
          if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            subset.push(nums[i]);
          //  System.out.println("dfs ->" + (i) + " start "+ start);
            dfs2(i + 1, nums, res, subset);
            subset.pop();
          //  Integer ele = subset.pop();
         //   System.out.println("Popped ->"+ ele);
        }
    }



    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1,2,3,4});
        System.out.println(res);
        List<String> a= new ArrayList<>();
        a.stream().filter(uu->uu.endsWith("ss")).collect(Collectors.toList());
    }

// [[], [1], [1, 2], [1, 2, 3], [1, 2, 3, 3], [1, 2, 3], [1, 3], [1, 3, 3], [1, 3], [2], [2, 3], [2, 3, 3], [2, 3], [3], [3, 3], [3]]
// [[], [1], [1, 2], [1, 2, 3], [1, 2, 3, 3], [1, 3], [1, 3, 3], [2], [2, 3], [2, 3, 3], [3], [3, 3]]

}
