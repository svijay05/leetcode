package greedy;

/*
Looks to me a sliding window problem
 */
public class MaximumSubArray {


    public static int maxSubArray(int[] nums) {

        int currSum = nums[0];
        int maxSum = currSum;
        for (int i = 1; i < nums.length; i++) {

            if (currSum < 0) {
                currSum = 0; // if previous sum negative reset
            }
            currSum = currSum + nums[i];
            maxSum = Math.max(currSum, maxSum);

        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,-1}));
    }

}
