package array;

public class ProductArray {

    public static int[] productExceptSelf(int[] nums) {

        /**

         8   2    |3|    4

       1  8   16    48    192

         192  24   12   4  1
         **/

        int[] prefix = new int[nums.length];

        int[] postfix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int factor = (i - 1 == -1) ? 1 : prefix[i - 1];
            prefix[i] = factor * nums[i];

        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int factor = (i + 1 == nums.length) ? 1 : postfix[i + 1];
            postfix[i] = factor * nums[i];

        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            result[i] = (i - 1 == -1 ? 1 : prefix[i - 1]) * (i + 1 == nums.length ? 1 : postfix[i + 1]);

        }

        return result;
    }

    public static void main(String[] args) {

        int[] a = new int[]{8, 2, 3, 4};
        System.out.println(productExceptSelf(a));
    }

}
