package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TopKFreequent {

    public int[] topKFrequent(int[] nums, int k) {
        String s = "";


        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int exi = map.getOrDefault(nums[i], 0);
            map.put(nums[i], exi + 1);
        }

        int[] result = map
                .entrySet()
                .stream()// Lis<Entry<Integer, Integ>>
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .limit(k)
                .mapToInt(Entry::getKey)
                .toArray();

        return result;
    }
}
