package bits;

public class NumberOfOnes {
    public int hammingWeight(int n) {

        int count =0;
        int mask =1;
        for (int i = 0; i < 32 ; i++) {

           if( (n & mask) !=0){
               count ++;
           }
           n= n>>1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfOnes().hammingWeight(7));
        System.out.println(Integer.toBinaryString(7));
    }
}
