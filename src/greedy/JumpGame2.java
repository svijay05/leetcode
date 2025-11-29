package greedy;

/**
 * check the furthest begining with start
 */
public class JumpGame2 {

    public static int jump(int[] nums) {
        int res = 0, r = 0, l = 0, fur = 0;

        while (r < nums.length - 1) {
            fur = 0;
            System.out.println("windoe-" + l + " " + r);
            for (int i = l; i <= r; i++) {
                fur = Math.max(fur, i + nums[i]);
            }
            l = r + 1;
            r = fur;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));

    }
}
