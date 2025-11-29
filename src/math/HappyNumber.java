package math;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {

        Set<Integer> hashset = new HashSet<>();
        hashset.add(n);
        while (true) {
            int res = happySum(n);
            if (res == 1) {
                break;
            }
            n = res;

            if (hashset.contains(n)) {
                //loop
                return false;
            } else {
                hashset.add(n);
            }

        }
        return true;
    }

    int happySum(int n) {

        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum = sum + (d * d);
            n = n / 10;
        }

        System.out.println("Sum = " + sum);
        return sum;
    }

    public static void main(String[] args) {
        boolean r = new HappyNumber().isHappy(2);
        System.out.println(r);

    }
}
