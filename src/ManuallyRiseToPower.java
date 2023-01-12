import com.shpp.cs.a.console.TextProgram;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * The program reads two numbers from the console.
 * The first is the number that will be raised to the power.
 * The second number is the degree. The second number can only be an integer
 */
public class ManuallyRiseToPower extends TextProgram {

    public void run() {
        Locale.setDefault(Locale.US);  // change double delimiter from "," to "."
        double[] arrWithUserInput = inputValue(); // array with two number from console
        double result = raiseToPower(arrWithUserInput[0], (int) arrWithUserInput[1]);
        println("Result " + result);
    }

    /**
     * Ask from console enter two numbers. First is base. Second is exponent
     * If there are mistakes in input. Console show error message
     *
     * @return array with two number from console
     */
    private double[] inputValue() {
        // I use scanner to fix problem with delimiter
        // in the school library "read" methods it doesn't work
        Scanner input = new Scanner(System.in);
        double[] arrWithUserInput = new double[2]; // array with console input
        try {
            println("Enter number");
            arrWithUserInput[0] = input.nextDouble();
            println("Enter power value");
            arrWithUserInput[1] = input.nextInt();
        } catch (InputMismatchException e) {
            println("incorrect input. You should enter only number. And second input must be integer");
        }
        return arrWithUserInput;
    }

    /**
     * First argument "base" raised to second argument "exponent"
     * Calculate and return result
     *
     * @param base     number that will be raised to the power
     * @param exponent power of the number
     * @return result number raised to a power
     */
    private double raiseToPower(double base, int exponent) {
        double result = 1; // result of power 0 is 1. As default result is 1
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        } else if (exponent < 0) {
            // // change negative value for exponent and call method again to calculate result for negative power
            return 1 / raiseToPower(base, exponent * -1);
        }
        return result;
    }
}
