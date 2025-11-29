package basics;

import java.util.Arrays;

public class DynamicArray {

    int arr[];
    int capacity;
    int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size =0;
    }

    public int get(int i) {
        //validations
        if(i<=0 || i>=size) throw new IllegalArgumentException("index out of bound");
        return arr[i];
    }

    public void set(int i, int n) {
        //validations
        if(i<=0 || i>=size) throw new IllegalArgumentException("index out of bound");
        arr[i] = n;
    }

    /**
     * will push the element n to the end of the array.
     * 
     * @param n
     */
    public void pushback(int n) {
        this.resize(); // if needed
        this.arr[this.arr.length] = n;
        this.size++;

    }

    /**
     * will pop and return the element at the end of the array. Assume that the
     * array is non-empty.
     * 
     * @return
     */
    public int popback() {
        if (this.size == 0) {
            throw new IllegalArgumentException("array is empty");
        }
        int lastE =  this.arr[this.size - 1];
        this.arr[size-1] = 0;
        this.size--;
        return lastE;
    }

    private void resize() {
        if (this.size == this.capacity) {
            this.capacity = this.capacity * 2;
            this.arr = Arrays.copyOf(this.arr, this.capacity);
        }

    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

}
