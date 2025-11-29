package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterface {

    public static void main(String[] args) {




        TreeMap<String, Integer> m = new TreeMap<>();
        m.put("zzzz",12);
        m.put("aa",10);



        Map<String, Integer> wordCounts = new HashMap<>();
        wordCounts.put("USA", 100);
        wordCounts.put("jobs", 200);
        wordCounts.put("software", 50);
        wordCounts.put("technology", 70);
        wordCounts.put("opportunity", 200);


        Map<String, String> wc2 = new HashMap<>();
        wc2.put("aaa","aaa");
        wc2.put("zzz","zzz");
        wc2.put("pp","pp");
        LinkedHashMap<String, String> sorted =
                wc2.entrySet().stream().sorted(Comparator.comparing(Entry::getKey))
                        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        Map<String,Integer>  sortedMap =  wordCounts.entrySet().
                stream().
                sorted((x,y)->y.getValue()-x.getValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        System.out.println(m);

        String s = "aaa bbb ccc dddd aaa";

        String tokens[] = s.split(" ");

        Map<String, Long> res =
                Arrays.stream(tokens)
                        .collect(
                                Collectors.groupingBy(Function.identity(),Collectors.counting())
                        );


        System.out.println(res);
        Function<String, String> toUpperCaseFunction = str -> str.toUpperCase();

        String result = test("aa", String::toUpperCase);
        System.out.println(result);

    }

    static <T,R> R test(T in, Function<T,R> func){

        return func.apply(in);
    }

}
