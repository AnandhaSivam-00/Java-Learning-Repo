package com.revature.components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 ** For the purpose of this application, the Multiplier class is dependent on the functionality of the Adder class,
 * making this a dependency of Adder.
 
 * This class is a potential bean that can be wired into another component
 * via dependency injection. A Bean is an object that is instantiated by Spring, rather than by the developer.
 * Dependency injection is the process of Spring inserting the instantiated Bean into another class.
 * "wiring" them together. This allows us to achieve loose coupling - we can switch which implementation of a class
 * we're currently using, or modify the existing classes we're using, while making less changes to the classes that
 * depend on this class.
 */
@Component
public class Multiplier {
    /**
     * TODO: Add an annotation over this Adder field to achieve field injection:
     *
     * Generally, field injection is not recommended, but it works for this example.
     * @param adder
     */
    @Autowired
    Adder adder;

    /**
     * Instead of using the * operator normally, leverage the Adder dependency to multiply numbers the hard way
     * @param a number 1
     * @param b number 2
     * @return a * b
     */
    public double multiply(double a, double b){
        double result = 0;
        for(int i = 0; i < Math.abs(b); i++){
            result = adder.add(result,a);
        }
        // Handle edge case of negative b
        if(b < 0) result *= -1;
        return result;
    }
}
