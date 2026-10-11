/**
 * 
 */
package expensemanager;

import java.util.Scanner;

/**
 * Reads and validates user input from the console. It repeatedly asks for input
 * until the user enters a valid value.
 */
public class InputReader
{
    private Scanner scanner;

    /**
     * Creates an input reader that reads from the console.
     */
    public InputReader()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads an integer from the user. If the input is invalid, the user is
     * asked to try again.
     *
     * @param message the message displayed before reading the input
     * @return the valid integer entered by the user
     */
    public int readInt(String message)
    {

        while (true)
        {
            System.out.println(message);
            String input = scanner.nextLine();
            try
            {
                int number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

    }

    /**
     * Reads a decimal number from the user. If the input is invalid, the user
     * is asked to try again.
     *
     * @param message the message displayed before reading the input
     * @return the valid decimal number entered by the user
     */
    public double readDouble(String message)
    {
        while (true)
        {
            System.out.println(message);
            String input = scanner.nextLine();
            try
            {
                double number = Double.parseDouble(input);
                return number;
            } catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Reads a non-empty text value from the user. If the input is blank, the
     * user is asked to try again.
     *
     * @param message the message displayed before reading the input
     * @return the non-empty text entered by the user
     */
    public String readString(String message)
    {
        while (true)
        {
            System.out.println(message);
            String input = scanner.nextLine();
            if (input.isBlank())
            {
                System.out.println("Please enter an explanation.");
            } else
            {
                return input;
            }
        }
    }
}
