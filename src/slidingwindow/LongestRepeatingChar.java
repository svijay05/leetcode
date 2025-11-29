package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingChar {

    public static int characterReplacement(String s, int k) {

        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length() && j < s.length(); ) {
            int c = map.getOrDefault(s.charAt(j), 0);
            map.put(s.charAt(j), ++c);

            int windowLength = j - i + 1;
            int currL = windowLength - mostOccurCharLen(map);
            if (currL <= k) {
                result = Math.max(result, windowLength);
                j++;
            } else {

                int d = map.getOrDefault(s.charAt(i), 0);
                if (d > 0) {
                    map.put(s.charAt(i), --d);
                }
                i++;
                map.put(s.charAt(j), --c);

            }
            // windowlength-most occuring character <=2

        }
        return result;
    }

    public static int mostOccurCharLen(Map<Character, Integer> map) {

        return map.entrySet().stream().mapToInt(e -> e.getValue()).max().getAsInt();
    }


    public static void main(String[] args) {

        System.out.println(characterReplacement("AABABBA", 1));
    }
}
