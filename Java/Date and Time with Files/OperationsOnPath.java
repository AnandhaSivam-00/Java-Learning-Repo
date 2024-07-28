import java.nio.file.*; // For new versions of java, also use java.io.*

// If you are working with paths, then use Path or Paths Class
// If you are working with files, then use Files Class

public class OperationsOnPath {
  public static void main(String args[]) {
    try {
      Path path = Path.of("Java/Date and Time with Files/Sample.txt");
      System.out.println(path);
      System.out.println(path.toAbsolutePath());

      System.out.println(Files.exists(path));

      System.out.println(Files.getLastModifiedTime(path)); // class --> FileTime

      System.out.println(Files.getOwner(path)); // class --> UserPrincipal

      // long mismatchIndex = Files.mismatch(path, Paths.get("Java/Date and Time with Files/temp.txt")); -- Not working
    } 
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}