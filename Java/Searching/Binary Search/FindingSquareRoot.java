import java.util.*;

public class FindingSquareRoot {
    private static int findingSquareRoot(int n) {
        int left = 1, right = n, mid;
        while(left < right) {
            mid = left + (right - left) / 2;
    
            if(mid * mid == n) {
                return mid;
            }
            else if(mid * mid > n) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findingSquareRoot(n));

        sc.close();
    }
}