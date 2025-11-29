package backtrack;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class combinationSum {


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> subset = new Stack<>();

        dfs(0, candidates, target,res,subset);

        return res;
    }


    static void dfs(int start, int[] nums, int target, List<List<Integer>> res,Stack<Integer> subset) {

        if(target<0) return;
        if(target == 0){
            res.add(new ArrayList<>(subset));
           return;
        }
        for (int i = start; i < nums.length ; i++) {

            subset.push(nums[i]);
            dfs(i,nums,(target-nums[i]),res,subset);
            subset.pop();

        }

    }


    public static void main(String[] args) {
        List<List<Integer>> r = combinationSum(new int[]{2, 3, 6, 7}, 7);

        System.out.println(r);

    }
}
