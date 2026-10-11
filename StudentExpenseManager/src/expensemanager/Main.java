/**
 * 
 */
package expensemanager;

/**
 * 
 */
public class Main
{
    public static void main(String[] args)
    {
        ExpenseManager expenseManager = new ExpenseManager();
        ExpenseConsole console = new ExpenseConsole(expenseManager);

        console.start();
    }

}
