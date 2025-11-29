package slidingwindow;

import java.util.HashMap;
import java.util.Map;
// getting timeout exception
public class MinimumWindowSubString {

    public static String minWindow(String s, String t) {

        // check t in s

        if (t.length() > s.length()) {
            return "";
        }
        if (s.contains(t)) {
            return t;
        }

        int w = t.length();
        int len = s.length();

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> tmapBk = new HashMap<>();

        for (int i = 0; i < w; i++) {
            int e = tmap.getOrDefault(t.charAt(i), 0);
            tmap.put(t.charAt(i), e + 1);
            tmapBk.put(t.charAt(i), e + 1);
        }

        int minL = len + 1;
        int minSTart = 0;
        int wstart = 0;
        for (int i = 0; i < len; i++) {

            if (tmap.containsKey(s.charAt(i)) && tmap.get(s.charAt(i)) > 0) {
                wstart = i;
            } else {
                continue;
            }

            while (wstart < len) {

                if (tmap.containsKey(s.charAt(wstart))) {
                    int val = tmap.get(s.charAt(wstart));
                    val--;
                    if (val <= 0) {
                        tmap.remove(s.charAt(wstart));
                    } else {
                        tmap.put(s.charAt(wstart), val);
                    }

                    if (tmap.size() == 0) {
                        if (wstart - i + 1 < minL) {
                            minL = wstart - i + 1;
                            minSTart = i;
                        }

                        break;

                    }

                }
                wstart++;

            }
            tmap.putAll(tmapBk);


        }

        return minL == len + 1 ? "" : s.substring(minSTart, minSTart + minL);

    }

    private static Map<Character, Integer> generateTmap(String t) {
        Map<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int e = tmap.getOrDefault(t.charAt(i), 0);
            tmap.put(t.charAt(i), e + 1);
        }
        return tmap;
    }

    public static void main(String[] args) {


        long start = System.currentTimeMillis();
        System.out.println(minWindow("abcdefgh","ba"));
        long end  = System.currentTimeMillis();

        System.out.println(end-start);
    }

}
