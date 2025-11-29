package math;

public class RotateImage {

    static int[][] rotate90(int[][] n) {
        int l = 0;
        int r = n.length - 1;
        while (l < r) {

            for (int i = 0; i < r - l; i++) {

                int top = l;
                int bottom = r;

                int topLeft = n[top][l];



            }

            l++;
            r--;
        }

        return null;
    }



    static void print(int[][] n) {

        for (int i = 0; i < n.length; i++) {

            for (int j = 0; j < n.length; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(a);
        rotate90(a);

    }

}
