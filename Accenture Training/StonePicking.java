// You are playing the following Nim Game with your friend:
// Initially, there is a heap of stones on the table. You and your friend will 
//alternate taking turns, and you go first. On each turn, the person whose turn it is will remove 1 to 
// 3 stones from the heap. The one who removes the last stone is the winner. Given n, the number of 
// stones in the heap, return true if you can win the game assuming both you and your friend play optimally, 
// otherwise return false.

// Input Format
// An integer n representing the number of stones in the heap.

// Constraints
// 1 <= n <= 231 - 1

// Output Format
// A boolean value indicating whether you can win the game assuming both you and your friend play optimally.

// Sample Input 0
// 4
// Sample Output 0
// false
// Sample Input 1
// 1
// Sample Output 1
// true
// Sample Input 2
// 2
// Sample Output 2
// true

import java.util.*;

public class Accenture_Stone_Picking {
    protected static boolean isWinGame(int n) {
        if(n % 4 == 0) {
            return false;
        }
        return true;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        System.out.println(isWinGame(n));
    }
}