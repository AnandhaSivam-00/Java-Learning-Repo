package com.revature.components;

import org.springframework.stereotype.Component;

/**
 * For the purpose of this application, the multiplier class is dependent on the functionality of the Adder class,
 * making the Multiplier class dependant on the Adder class.
 * 
 *
 * This class is a potential bean that can be wired into another component
 * via dependency injection. A Bean is an object that is instantiated by Spring, rather than by the developer.
 * Dependency injection is the process of Spring inserting the instantiated Bean into another class.
 * "wiring" them together. This allows us to achieve loose coupling - we can switch which implementation of a class
 * we're currently using, or modify the existing classes we're using, while making less changes to the classes that
 * depend on this class.
 *
 * There is no need to change anything within this class.
 */
@Component
public class Adder {
    /**
     * Return the sum of two numbers.
     * @param a number 1
     * @param b number 2
     * @return a + b
     */
    public double add(double a, double b){
        return a + b;
    }
}
