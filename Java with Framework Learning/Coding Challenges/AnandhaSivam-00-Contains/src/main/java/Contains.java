import java.util.Arrays;

public class Contains {

    /**
     * This method should search an array to see if that array contains some value.
     * You will need to use a for loop to check every value of the array to see if it matches the target value.
     *
     * @param arr array to be manipulated.
     * @param target the value that the method should be searching for.
     * @return true if arr contains target, false otherwise.
     */
    public boolean arrayContains(int[] arr, int target){
        Arrays.sort(arr);

        int left = 0, right = arr.length-1, mid;

        while(left < right) {
            mid = left + (right - left / 2);

            if(arr[mid] == target) {
                return true;
            }
            else if(arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return false;
    }
}