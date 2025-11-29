package dynamicprogramming;

import java.util.Stack;

public class DecodeWays {

    public static int numDecodings(String s) {

        if (s.startsWith("0")) {
            return 0;
        }

        int[] dp = new int[s.length()];
        //  dp[0] = 1; // empty string
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') { // previous digit not zero?
                dp[i] = dp[i] + dp[i - 1];
            }
            if (
                    (s.charAt(i - 1) == '1' ||
                            (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))
            ) {

                dp[i] = i - 2 >= 0 ? (dp[i] + dp[i - 2]) : (dp[i] + 1);

            }
        }
        return dp[s.length() - 1];


    }


    public static void main(String[] args) {

        System.out.println("count->" + numDecodings("721 22"));
    }

}
