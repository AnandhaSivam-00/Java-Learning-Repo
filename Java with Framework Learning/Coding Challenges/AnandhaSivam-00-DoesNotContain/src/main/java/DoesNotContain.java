import java.util.*;
public class DoesNotContain {
    /**
     * The inverse of the contains value challenge: check if the array does *not* contain the value.
     * You should think critically about the logic that you write within the for loop.
     *
     * For a trickier problem like this, you should try explaining your thought process of working
     * through this problem with pencil and paper in plain English before attempting it in code.
     * For instance: for the contains problem, your code had to check every value to see if the value
     * matches the target, and if it matched the target, the array was sure to contain the target. Think
     * of a similar process here.
     *
     * @param arr the array we will be manipulating.
     * @param target the value we are searching for.
     * @return true if arr does not contain target. false otherwise.
     */
    public boolean arrayDoesNotContain(int[] arr, int target){
        Arrays.sort(arr);

        int left = 0, right = arr.length -1, mid;

        while(left < right) {
            mid = right - left / 2;

            if(arr[mid] == target) {
                return false;
            }
            else if(arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return true;
    }
}
