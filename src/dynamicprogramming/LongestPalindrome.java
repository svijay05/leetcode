package dynamicprogramming;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        int len = s.length();
        boolean dp[][] = new boolean[len][len];

        int start = 0, end = 0, max = 1;

        for (int i = len - 1; i >= 0; i--) {

            for (int j = i; j < len; j++) {

                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        //check i+1, j-1
                    }
                }

                if (dp[i][j]) {

                    if (j - i + 1 > max) {

                        max = j - i + 1;
                        start = i;
                        end = j;
                    }


                }

            }
        }
        print(dp, len);
        System.out.println("Start =" + start + " End = " + end + " Max = " + max);

        return s.substring(start, end + 1);
    }

    public static void print(boolean[][] dp, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                System.out.print(dp[i][j] + "   ");

            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("cbbd"));
    }


}
