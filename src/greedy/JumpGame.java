package greedy;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int len = nums.length;

        if (len < 0) {
            return false;
        }

        int flagPole = len - 1;

        for (int i = len - 2; i >= 0; i--) {

            if (i + nums[i] >= flagPole) {
                flagPole = i;
            }
        }

        System.out.println(flagPole);
        if (flagPole == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));

    }
}
