package dynamicprogramming;

public class HouseRobber {

    public static int rob(int[] nums) {

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i % 2 == 0) {

                sum1 = sum1 + nums[i];
                if (i + 1 < nums.length) {
                    sum1 = Math.max(sum1, (sum1 - nums[i]) + nums[i + 1]);
                }

            } else {
                sum2 = sum2 + nums[i];
                if (i + 1 < nums.length) {
                    sum2 = Math.max(sum2, (sum2 - nums[i]) + nums[i + 1]);
                }
            }
        }
        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        int[] h = {2, 1, 1,2};
        System.out.println(rob(h));
    }
}
