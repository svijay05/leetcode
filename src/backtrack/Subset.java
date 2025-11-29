package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subset {


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }


    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        System.out.println(result);
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            System.out.println("Start generateSubsets "+(i+1));
            generateSubsets(i + 1, nums, current, result);
             System.out.println("Done generateSubsets "+(i+1));
            current.remove(current.size() - 1);
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
            System.out.println("i-> "+ i + "  Start ->" + start);
            subset.push(nums[i]);
            dfs2(i + 1, nums, res, subset);
            subset.pop();
        }
    }



    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1,2,3,4,5});
        System.out.println(res);
    }



}
