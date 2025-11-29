package slidingwindow;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        if(len == 0) return 0;

        String res="";
        int resSize = 0;

        for(int i=0;i<len;i++){
            String ch  = Character.toString(s.charAt(i));
            if(res.contains(ch)){
                res = res.substring(res.indexOf(ch)+1);
            }
            res = res + ch;
            resSize= Math.max(resSize, res.length());
        }
        return resSize;

    }
}
