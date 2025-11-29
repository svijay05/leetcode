package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Palindrome {


    public static boolean isPalindrome(String s) {

        s = s.toLowerCase(Locale.ROOT);

        s = s.replaceAll("[^a-z0-9]", "");

        System.out.println(s);

        for (int i = 0; i < s.length() / 2; i++) {

            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome("A man, a plan, a canal: Panama");
        List<String> a = new ArrayList<>();
        a.add("apple");
        System.out.println(a.contains(null));
    }
}
