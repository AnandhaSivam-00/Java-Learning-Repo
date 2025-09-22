package com.revature;

import com.revature.components.Adder;
import com.revature.components.Multiplier;
import com.revature.components.Squarer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * To show off how dependency injection works, this class
 * uses the Adder, Multiplier, and Squarer classes to
 * perform mathematical operations and return the results
 * as strings.
 *
 * The @Autowired annotation will inform Spring to automatically find the most appropriate bean to wire into this
 * class (based on the name & type of the Object used.) The @Autowired annotation can be used in 3 different ways:
 * constructor injection (above a constructor), setter injection (over a setter method), and field injection
 * (above the injected field declaration itself, as is done here).
 *
 * TODO: Add the @Autowired annotation to achieve dependency injection in 3 different ways (constructor, setter, and field)
 */
@ComponentScan(basePackages = "com.revature.components")
@Component
public class ArithmeticPresentationLayer {
    @Autowired
    private Adder adder;
    private Multiplier multiplier;
    private Squarer squarer;

    @Autowired
    public void setMultiplier(Multiplier multiplier) {
        this.multiplier = multiplier;
    }

    @Autowired
    public ArithmeticPresentationLayer(Squarer squarer) {
        this.squarer = squarer;
    }

    public static void main(String[] args) {
        // Use this main method for manual testing (optional)
        // Create the Spring container
        ApplicationContext context =  new AnnotationConfigApplicationContext(ArithmeticPresentationLayer.class);

        // Retrieve the RoryApplication bean from the container
        ArithmeticPresentationLayer app = context.getBean(ArithmeticPresentationLayer.class);
    }

    /**
     * @param a - number 1
     * @param b - number 2
     * @return the addition operation as a String, see tests for specific formatting
     */
    public String addConvertToString(double a, double b){
        return String.format("The result of %.1f + %.1f is %.1f", a, b, adder.add(a,b));
    }
    /**
     * @param a - number 1
     * @param b - number 2
     * @return the multiplication operation as a String, see tests for specific formatting
     */
    public String multiplyConvertToString(double a, double b){
        return String.format("The result of %.1f * %.1f is %.1f", a, b, multiplier.multiply(a,b));
    }

    /**
     * @param a - number 1
     * @return the square operation as a String, see tests for specific formatting
     */
    public String squareConvertToString(double a){
        return String.format("The result of %.1f squared is %.1f", a, squarer.getSquare(a));
    }

}
