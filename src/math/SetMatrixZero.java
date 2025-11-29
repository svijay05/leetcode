package math;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class SetMatrixZero {

    public  void setZeroes(int[][] m) {

        // first pass find indexes

        int row = m.length;
        int col = m[0].length;

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (m[i][j] == 0) {
                    list.add(new Pair(i, j));
                }

            }
        }

        // second pass set to zero

        for (Pair p:list) {
            fillZeroes(p,row,col,m);
        }


    }

    private void fillZeroes(Pair p,int row, int col, int[][] m) {


        int i = p.getI();
        int j = p.getJ();


        for(int k=0;k<col;k++){
            m[i][k] = 0;
        }

        for(int l=0;l<row;l++){
            m[l][j] = 0;
        }
    }



        private static class Pair {

        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getJ() {
            return j;
        }

        public int getI() {
            return i;
        }
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
            int[][] a = new int[][]{{1, 2, 3, 4}, {5,0 , 7, 8}, {9, 8, 10, 11}};
            new SetMatrixZero().setZeroes(a);
            print(a);
    }
}
