package math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class spriralMatrix {


    static void print(int[][] n) {

        int row = n.length;
        int col = n[0].length;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 8, 10, 11}};
        int[][] b = new int[][]{{1, 2, 3}, {5, 6, 7}, {9, 8, 10}};
        int[][] c = new int[][]{{1, 2, 3}};
        int[][] d = new int[][]{{1}, {5}, {9}};

        print(d);
        spiral(d);







    }

    private static void spiral(int[][] a) {
        int l = 0;
        int r = a[0].length - 1;
        int bottom = a.length - 1;
        int top = 0;

        List<Integer> res = new ArrayList<>();
        while (l <= r && top <= bottom) {

            // left to right

            for (int i = l; i <= r; i++) {
                System.out.print(a[l][i] + " ");
                res.add(a[l][i]);
            }
            top = top+1;

            // top to botom
            for (int i = top; i <= bottom; i++) {
                System.out.print(a[i][r] + " ");
                res.add(a[i][r]);
            }

            r = r-1;

        if(l <= r && top <= bottom) {

            // bottom right to left
            for (int i = r; i >= l; i--) {
                System.out.print(a[bottom][i] + " ");
                res.add(a[bottom][i]);
            }

            bottom = bottom - 1;

            // bottom  to up
            for (int i = bottom; i >= top; i--) {
                System.out.print(a[i][l] + " ");
                res.add(a[i][l]);
            }

            l++;

        }

        }
        System.out.println();

        System.out.println(l + "-> " + r + " ->" + top + "-> " + bottom);



    }

}
