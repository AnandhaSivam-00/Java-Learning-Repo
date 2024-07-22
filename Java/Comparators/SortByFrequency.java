import java.util.*;

public class SortByFrequency {

  protected static String comparatorMethod(List<String> str) {
    Map<String, Integer> freqMap = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    for(int i=0; i<str.size(); i++) {
      freqMap.put(str.get(i), freqMap.getOrDefault(str.get(i), 0) + 1);
    }

    List<Map.Entry<String, Integer>> freqList = new ArrayList<>(freqMap.entrySet());

    Collectors.sort(freqList, (obj1, obj2) -> obj1.getValue() == obj2.getValue() ? obj2.getKey() - obj1.getKey() : obj1.getValue() - obj2.getValue());

    for(Map.Entry<String, Integer> entry : freqList) {
      for(int i=0; i<entry.getValue(); i++) {
        sb.append(entry.getKey()).append(" ");
      }
    }

    return sb.toString();
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();

    List<String> strList = Arrays.asList(str.split(" "));

    System.out.println(comparatorMethod(strList));
  }
}