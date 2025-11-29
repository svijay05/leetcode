package array;

public class MaxProductSubarray {

    public static int maxProduct(int[] nums) {

        int max = 1;
        int min = 1;

        int result = nums[0];
        for (int num : nums) {

            min = Math.min(num * min, min);
            max = Math.max(num * min, max);

            System.out.println("num - >" + num + " min ->" + min + " max->" + max);

            result = Math.max(min, max);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-1, -2, -3}));
    }

}
