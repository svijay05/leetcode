package twopointer;

public class TrappingRainWater {

    public static int trap(int[] h) {
        int ans = 0;
        int l= 0; int r= h.length-1;

        if(r<2) return 0;

        int leftMax= h[l];
        int rightMax =h[r];

        while(l<r){


            if(leftMax<rightMax){
                l++;
                leftMax =  Math.max(leftMax, h[l]);

                if((leftMax - h[l]) > 0){
                    ans =  ans + (leftMax - h[l]) ;
                }
            }else{
                r--;
                rightMax =  Math.max(rightMax, h[r]);

                if((rightMax - h[r]) > 0){
                    ans =  ans + (rightMax - h[r]) ;
                }
            }

        }
        return ans;
    }


    public static void main(String[] args) {

  /*      int a[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap(a);
        System.out.println(result);*/

        String d ="abcdefgh";

        System.out.println( d.substring(d.indexOf("d")+1) );

        System.out.println();


    }

}
