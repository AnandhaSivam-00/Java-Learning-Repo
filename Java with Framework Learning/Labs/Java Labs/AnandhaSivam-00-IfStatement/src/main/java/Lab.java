
public class Lab {
    /**
     * An if statement uses a conditional statement (within parentheses) to determine if the code
     * within {curly braces} should run.
     * If statements can be coupled with an else{} statement or else if(){} statement.
     *
     * Let's make an if statement that does the following:
     * if bool is true, return x.
     * if bool is false, return y.
     * 
     * All variables needed to solve the problem are provided by the method parameters - boolean bool, int x, int y.
     * This means that you can use the variables bool, x, and y freely, within the if statement, to solve the problem.
     *
     * Additional Resource if needed: https://www.w3schools.com/java/java_conditions.asp
     *
     * @param bool a true/false value that determines if x or y is to be returned.
     * @param x first number to be compared.
     * @param y second number to be compared.
     * @return x if bool is true. if bool is false, return y.
     */
    public int ifExample(boolean bool, int x, int y){
        if(bool) {
            return x;
        }
        else {
            return y;
        }
    }
}
