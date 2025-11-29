package stack;

import java.util.Stack;

public class DailyTemperature {

    public static int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <temperatures.length ; i++) {
            // stack only store array index
            // when you see  a bigger temperature pop and calculate
            while (!stack.isEmpty()&& temperatures[i]>temperatures[stack.peek()]){
                int prev = stack.pop();
                result[prev] =  i - prev;

            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

      int [] r =  dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }
}
