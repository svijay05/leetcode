package twopointer;

import static java.lang.Math.min;

public class ContainerWithMostWater {

    public static int maxArea(int[] h) {

        int len = h.length;

        int l = 0; // 0
        int r = len - 1; //2

        int area = (r - l) * min(h[l], h[r]);
        System.out.println("Area == " + area);

        while (l < r) {

            if (h[l] < h[r]) {
                l++;
            } else {
                r--;
            }

            int temp = (r - l) * min(h[l], h[r]);
            if (temp > area) {
                area = temp;
            }
            System.out.println("Temp ->" + temp + "  Area ->" + area);

        }
        return area;
    }

    public static void main(String[] args) {

        int a[] = new int[]{1, 3, 2, 5, 25, 24, 5};
        int result = maxArea(a);
        System.out.println(result);
    }

}
