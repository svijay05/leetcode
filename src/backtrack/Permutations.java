package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<Integer> subset = new Stack<>();
        dfs(0, nums, subset, res);
        return res;
    }

    static void dfs(int start, int[] nums, Stack<Integer> subset, List<List<Integer>> res) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(subset.contains(nums[i])) continue;
            subset.push(nums[i]);
            dfs(i + 1, nums, subset, res);
            subset.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
