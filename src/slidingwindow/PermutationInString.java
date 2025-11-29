package slidingwindow;

import java.util.Arrays;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        // check s1 in s2.

        int w = s1.length();
        int len = s2.length();

        int[] freq1 = new int[26];

        int[] freq2 = new int[26];

        for (int i = 0; i < w; i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            freq2[s2.charAt(i) - 'a']++;
           // nice trick, when window moves out of s1 length, decrease character count.
            if (i >= w) {
                freq2[s2.charAt(i - w) - 'a']--;
            }

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "eidbaooo"));
    }
}
