import java.util.Stack;

public class Main {




    public static void main(String[] args) {

        int a[] = {1,2,1,1};
        int b[] = {1,1,2};
        int c[] = {1,1};


        int aSum = total(a); // 5  4   3  1
        int bSum = total(b); // 4  4   2  2
        int cSum = total(c); // 2  2   2  2


        Stack<Integer> stackA =  getStackObj(a);
        Stack<Integer> stackB =  getStackObj(a);
        Stack<Integer> stackC =  getStackObj(a);


        do{

            if(aSum >= bSum && aSum>=cSum){
                aSum = aSum - stackA.pop();
            }

            if(bSum >= aSum && bSum>=cSum){
                bSum = bSum - stackB.pop();
            }


            if(cSum >= aSum && cSum>=aSum){
                cSum = cSum - stackC.pop();
            }

        }
        while ( !(aSum == bSum) && !(bSum == cSum));


    }

    static int total(int[] a){
        int sum =0;
        for(int i=0;i<a.length;i++){
            sum =sum + a[i];
        }
        return sum;
    }

    static Stack<Integer> getStackObj(int[] a){

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            stack.push(Integer.valueOf(a[i]));
        }
        return stack;

    }


}