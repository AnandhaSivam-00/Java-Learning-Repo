import java.util.*;

public class SortByFrequency {

  protected static String comparatorMethod(List<String> str) {
    Map<String, Integer> freqMap = new HashMap<>();
    StringBuilder resultStr = new StringBuilder();

    for(int i=0; i<str.size(); i++) {
      freqMap.put(str.get(i), freqMap.getOrDefault(str.get(i), 0) + 1);
    }

    Collections.sort(str, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        // Below two works only continous elements like 1 1 1 2 2 3 3 
        //return freqMap.get(o1).compareTo(freqMap.get(o2));
        // return freqMap.get(o1) - freqMap.get(o2);

        return freqMap.get(o2).compareTo(freqMap.get(o1));
      }
    });

    for(int i=0; i<str.size(); i++) {
      resultStr.append(str.get(i) + " ");
    }

    return resultStr.toString().trim();
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();

    List<String> strList = Arrays.asList(str.split(" "));

    System.out.println(comparatorMethod(strList));
  }
}