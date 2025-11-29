package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {

        if (amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    System.out.println("i=" + i + " coin=" + coin + " -->minOf(" + dp[i] + "," + (1+dp[i - coin]) + ")");
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            System.out.println("\n");
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;

    }

    public static void main(String[] args) {

        int[] e = new int[]{1, 3, 4, 5};
        System.out.println(coinChange(e, 7));

    }

}
