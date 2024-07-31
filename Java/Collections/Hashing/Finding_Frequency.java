import java.util.*;

public class Finding_Frequency {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt(), search = sc.nextInt(), i;
    int freq[] = new int[125];

    while(num != 0) {
      freq[num % 10]++;
      num /= 10;
    }

    System.out.println(freq[search]);
  }
}