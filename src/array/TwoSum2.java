package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{};
    }


    public static int lookup(int[] a) {

        int max = Integer.MIN_VALUE;

        for (int j : a) {
            if (j > max) {
                max = j;
            }
        }

        Set<Integer> lookupTable = new HashSet<>();
        for (int i = 0; i < 2 * max; i++) {
            lookupTable.add((int) Math.pow(2, i));
        }

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                System.out.println("contains "+ (i+j));
                if (lookupTable.contains(i + j)) {
                    count++;
                }

            }
        }

        return count;
    }


    public static void main(String[] args) {

       /* int a[] = new int[]{-1, 0, 1, 2, -1, -4};
        int[] result = twoSum(a, 6);

        for (int e : result) {
            System.out.println(e);
        }*/

        System.out.println(lookup(new int[]{1, -1, 2, 3}));

        Map<String,String > a = new HashMap<>();

       a.put("a","aval");
       a.put("b","bval");

       for (Map.Entry<String,String> kv : a.entrySet()){
           System.out.println( kv.getKey() );
           System.out.println(kv.getValue());
       }

        List<String> aa =  new ArrayList<>();
       aa.add("zzzz");
       aa.add("yyy");
       aa.add("aa");
        System.out.println(aa);
       Collections.sort(aa, (i,j)->j.compareTo(i));
        System.out.println(aa);

    }

}
