package binarysearch;

public class SearchRotatesSorted {


    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            //left sorted
            if (nums[left] <= nums[mid]) {
                // if in sorted part
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                }
                //else check other part
                else {
                    left = mid + 1;
                }

            }//right sorted
            else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }


        }

        return -1;
    }

    public static void main(String[] args) {
        int res = search(new int[]{7,8,9,1,2,3,4,5,6}, 5);
        System.out.println(res);
    }


}
