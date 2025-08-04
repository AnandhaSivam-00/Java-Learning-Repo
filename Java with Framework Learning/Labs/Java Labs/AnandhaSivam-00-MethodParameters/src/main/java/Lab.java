
public class Lab {
    /**
     * This method should return whatever String was passed into it by whatever invoked it (in this case, the test),
     * instead of returning "return text please!"
     *
     * for example:
     * String str = copy("hello");
     * System.out.println(str); -> prints out "hello"
     *
     * You may notice that replacing the String "return text please!" with "hello" or "polly" will work for one
     * test, but will fail the other. This is because the test cases are setting up different scenarios to test the
     * functionality of this method - it will always expect the method to return the same variable that was provided
     * to the method. You can also try experimenting with the following guesses, as one of them will be the correct 
     * answer. Please note that many of these will not compile, as evidenced by a "red line" under your code.
     *
     * return "hello"; | return String "hello";
     * return hello;   | return String hello;
     * return "polly"; | return String "polly";
     * return polly;   | return String polly;
     * return "text";  | return String "text";
     * return text;    | return String text;
     * return;         | return String;
     *
     * @param text is a parameter passed into this method by whatever called it.
     * @return text.
     */
    public String copy(String text){
        return text;
    }
}