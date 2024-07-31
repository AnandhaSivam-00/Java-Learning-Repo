import java.util.*;

public class GroupingAnagrams {
  protected static List<List<String>> withoutMap(String[] strs) {
    List<String> sortedList = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    
    boolean isVisited[] = new boolean[strs.length];

    for(String str : strs) {
      char chArr[] = str.toCharArray();
      Arrays.sort(chArr);
      sortedList.add(new String(chArr));
    }

    for(int i=0; i<strs.length; i++) {
      if(!isVisited[i]) {
        result.add(new ArrayList<>());
        result.get(result.size() - 1).add(strs[i]);
      }
      for(int j=i+1; j<strs.length; j++) {
        if(!isVisited[j] && sortedList.get(i).equals(sortedList.get(j))) {
          result.get(result.size() - 1).add(strs[j]);
          isVisited[j] = true;
        }
      }
    }

    return result;
  }
  
  protected static List<List<String>> UsingMap(String[] strArr) {
    Map<String, List<String>> group = new HashMap<>();

    String sortedStr;

    for(int i=0; i<strArr.length; i++) {
      char chArr[] = strArr[i].toCharArray();
      Arrays.sort(chArr);

      sortedStr = new String(chArr); // Converting into string back

      if(!group.containsKey(sortedStr)) {
        group.put(sortedStr, new ArrayList<>());
        group.get(sortedStr).add(strArr[i]);
      }
      else {
        group.get(sortedStr).add(strArr[i]);
      }
    }

    List<List<String>> result = new ArrayList<>(group.values());

    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    String strArr[] = str.split(" ");

    System.out.println(UsingMap(strArr));
    System.out.println(withoutMap(strArr));
  }
}