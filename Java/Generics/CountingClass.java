// Write a generic method to count the number of elements in a collection 
// that have a specific property (for example, odd integers, prime numbers, palindromes)

import java.util.*;
import java.util.function.Predicate;

class Counting {
  protected static <T> int count(Collection<T> collection, Predicate<T> predicate) {
    return (int) collection.stream().filter(predicate).count();
  }
}

public class CountingClass {
  protected static boolean isPrime(int n) {
    if(n <= 1) {
      return false;
    }
    else {
      for(int i=2; i<=Math.sqrt(n); i++) {
        if(n % i == 0) {
          return false;
        }
      }
      return true;
    }
  }
  
  public static void main(String args[]) {
    List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("Odd Numbers: " + Counting.count(numList, n -> n % 2 != 0));

    System.out.println("Prime Numbers: " + Counting.count(numList, n -> isPrime(n)));

    List<String> strList = Arrays.asList("madam", "hello", "world", "level", "java");
    System.out.println("Palindrome Strings: " + Counting.count(strList, s -> s.equals(new StringBuilder(s).reverse().toString())));
  }
}