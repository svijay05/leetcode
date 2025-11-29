package codesignal;

public class StringMatch {

    private static int solution(String pattern, String source) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == 'a' || source.charAt(i) == 'e' || source.charAt(i) == 'i' || source.charAt(i) == 'o'
                    || source.charAt(i) == 'u') {
                sb.append('0');

            } else {
                sb.append('1');
            }

        }

        String s = sb.toString();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i+3 < s.length() && s.substring(i, i + 3).equals(pattern)) {

                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        int ans = solution("100", "codesignal");
        System.out.println(ans);


    }

}
