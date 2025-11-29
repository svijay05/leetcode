package dynamicprogramming;

public class PalindromicSubstrings {

    public static int countSubstrings(String s) {

        int len = s.length();

        int count = 0;

        boolean dp[][] = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j <= len - 1; j++) {

                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {
                    count = count + 1;
                    System.out.println(count + " -> " + s.substring(i, j+1));
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

}
