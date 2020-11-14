package com.chlemagne;

/**
 * Factorial class shows the difference between Iteration and Recursion.
 */
public class Factorial {

    /**
     * Factorial using iteration (loop).
     * @param number
     * @return int
     */
    public static int factorialIteration(int number) {
        int factorial = 1;
        for (int i = number; i > 1; i--)
            factorial *= i;

        return factorial;
    }

    /**
     * Factorial using recursion.
     * @param number
     * @return
     */
    public static int factorialRecursion(int number) {
        /*
            Math:
            =====
            3! = 3 * 2 * 1

            4! = 4 * 3 * 2 * 1
               = 4 * 3!

            Code:
            =====
            f(4) = 4 * f(3)       --> recursion

            f(n) = n * f(n - 1)   --> recursion

            Simulation f(4):
            ===============
            >>> STACK (LIFO) >>>
            f(4) = 4 * f(3)
                       f(3) = 3 * f(2)
                                  f(2) = 2 * f(1)
                                             f(1) = 1 * f(0)
                                                        f(0) = 1
                                             f(1) = 1 * 1
                                  f(2) = 2 * 1
                       f(3) = 3 * 2
            f(4) = 4 * 6
            f(4) = 24
         */

        // base condition; without this, Java virtual machine will enter an infinite loop
        if (number == 0)
            return 1;

        return number * factorialRecursion(number - 1);
    }
}
