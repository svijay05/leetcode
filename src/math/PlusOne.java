package math;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        int len = digits.length;

        digits[len - 1] = digits[len - 1] + 1;

        for (int i = len - 1; i >= 0; i--) {

            if (digits[i] == 10 && i - 1 >= 0) {
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
            }
        }
        //if MSB is max
        if (digits[0] == 10) {
            digits[0] = 0;
            int[] newArray = new int[len + 1];
            newArray[0] = 1;
            for (int i = 0; i < len; i++) {
                newArray[i + 1] = digits[i];
            }
            return newArray;
        }

        return digits;
    }

    public static void main(String[] args) {
        int a[] = {1,2, 9, 9};
        int[] r = new PlusOne().plusOne(a);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }


    }
}
