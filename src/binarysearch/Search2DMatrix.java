package binarysearch;

import java.util.Arrays;

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] m, int target) {

        int row = m.length;
        int col = m[0].length;

        // find row with binary search

        int rowStart = 0, rowEnd = row - 1;
        int foundRow = -1;
        while (rowStart <= rowEnd) {
            int mid = (rowEnd + rowStart) / 2;

            if (target >= m[mid][0] && target <= m[mid][col - 1]) {
                foundRow = mid;
                break;
            } else if (target < m[mid][0]) {
                rowEnd = rowEnd - 1;
            } else {

                rowStart = rowStart + 1;

            }

        }

        if (foundRow == -1) {
            return false;
        }
        //System.out.println("Found row -->" + foundRow);
        return bin(m[foundRow], target);
    }


    private static boolean bin(int a[], int target) {

        int start = 0;
        int end = a.length;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (a[mid] == target) {

                return true;
            } else if (target < a[mid]) {

                end = end - 1;

            } else {

                start = start + 1;
            }


        }

        return false;

    }


    private static void print(int a[][]) {
        int row = a.length;
        int col = a[0].length;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + "\t");
            }

            System.out.println("");

        }

    }

    public static void main(String[] args) {

        int a[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        // System.out.println( Arrays.deepToString(a) );

        print(a);
        boolean ans = searchMatrix(a, 6);
        System.out.println(ans);
    }
}
