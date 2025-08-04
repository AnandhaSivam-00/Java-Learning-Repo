
/**
 * If we want to make programs that "do something", we're going to need to create instructions that change
 * depending on the current state of the program.
 * Therefore, we're inevitably going to run into boolean expressions (ie true/false statements).
 * Let's start with the different ways to compare two unknown numbers, in this case a and b.
 * 
 * Boolean logic can be thought of just like a math equation such as 4*5 = 20. When programming, however,
 * we can almost never assume that a value is known. Instead, we'd have to represent that equation as:
 * int result = a*b; where a and b represent two unknown numbers. This can also be applied logical expressions. 
 * If we consider that programs interpret the symbol '==' as an operation that determines if two values are equal 
 * to each other, we'd say that 4==5 is FALSE, and 4==4 is TRUE. If the two numbers are unknown numbers
 * represented by 'a' and 'b', the expression may be written as: boolean result = a==b;. For any problem in this 
 * lab, this expression can be written on a single line, as a boolean expression can be resolved instantly just
 * like a math equation. For instance, the solution to 'isEqual' would be the single line return a==b;
 * 
 * You'll need to know more operators to complete the remaining parts of the lab. You can find resources online
 * by searching for keywords like: java comparison operators.
 */
public class Lab {
    /**
     * @param a the first number to be compared.
     * @param b the second number to be compared.
     * @return true if a is equal to b, false otherwise.
     */
    public boolean isEqual(int a, int b){
        return a == b;
    }

    /**
     * @param a the first number to be compared.
     * @param b the second number to be compared.
     * @return true if a is greater than b, false otherwise.
     */
    public boolean greaterThan(int a, int b){
        return a > b;
    }
    /**
     * @param a the first number to be compared.
     * @param b the second number to be compared.
     * @return true if a is less than b, false otherwise.
     */
    public boolean lessThan(int a, int b){
        return a < b;
    }
    /**
     * @param a the first number to be compared.
     * @param b the second number to be compared.
     * @return true if a is greater than or equal to b, false otherwise.
     */
    public boolean greaterThanOrEqualTo(int a, int b){
        return a >= b;
    }
    /**
     * @param a the first number to be compared.
     * @param b the second number to be compared.
     * @return true if a is less than or equal to b, false otherwise.
     */
    public boolean lessThanOrEqualTo(int a, int b){
        return a <= b;
    }

    /**
     * @param a the first number to be compared.
     * @param b the second number to be compared.
     * @return true if a is not equal to b, false otherwise.
     */
    public boolean notEqualTo(int a, int b){
        return a != b;
    }
}
