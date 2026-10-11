/**
 * 
 */
package expensemanager;

import java.util.List;

/**
 * Provides a console-based user interface for the expense manager. It reads
 * user input, calls the appropriate operations in {@link ExpenseManager}, and
 * displays the results.
 */
public class ExpenseConsole
{
    private ExpenseManager expenseManager;
    private InputReader inputReader;

    /**
     * Creates a new console interface for the specified expense manager.
     *
     * @param e the manager used to access and modify expenses
     */
    public ExpenseConsole(ExpenseManager e)
    {
        this.expenseManager = e;
        inputReader = new InputReader();
    }

    /**
     * Reads an expense ID from the user and displays the matching expense.
     */
    public void handleFindExpense()
    {
        int id = inputReader.readInt("Enter ID: ");
        Expense foundExpense = expenseManager.findExpenseById(id);
        if (foundExpense == null)
        {
            System.out.println("Expense not found.");
        } else
        {
            foundExpense.printInfo();
        }
    }

    /**
     * Reads an expense ID from the user and removes the matching expense.
     */
    public void handleRemoveExpense()
    {
        int id = inputReader.readInt("Please Enter an ID: ");
        boolean foundId = expenseManager.removeExpenseById(id);
        if (foundId)
        {
            System.out.println("Expense removed successfully.");
        } else
        {
            System.out.println("Expense not found.");
        }

    }

    /**
     * Finds and displays the expense with the highest cost.
     */
    public void handleFindLargestExpense()
    {
        Expense largestExpense = expenseManager.findLargestExpense();
        if (largestExpense == null)
        {
            System.out.println("Expense not found.");
        } else
        {
            largestExpense.printInfo();
        }

    }

    /**
     * Reads a category from the user and displays all expenses belonging to the
     * selected category.
     */
    public void handleFindExpensesByCategory()
    {

        System.out.println("1. RENT");
        System.out.println("2. FOOD");
        System.out.println("3. TRANSPORT");
        System.out.println("4. STUDY");
        System.out.println("5. OTHER");
        int option = inputReader.readInt("Choose a category:");
        Category selectedCategory;
        switch (option)
        {
        case 1:
            selectedCategory = Category.RENT;
            break;
        case 2:
            selectedCategory = Category.FOOD;
            break;
        case 3:
            selectedCategory = Category.TRANSPORT;
            break;
        case 4:
            selectedCategory = Category.STUDY;
            break;
        case 5:
            selectedCategory = Category.OTHER;
            break;
        default:
            System.out.println("Invalid category.");
            return;
        }
        List<Expense> foundExpenses = expenseManager
                .findExpenseByCategory(selectedCategory);
        if (foundExpenses.isEmpty())
        {
            System.out.println("No expenses found in this category.");
        } else
        {
            for (Expense expense : foundExpenses)
            {
                expense.printInfo();
                System.out.println();
            }
        }

    }

    /**
     * Reads the information for a new expense from the user and adds it to the
     * expense manager.
     */
    public void handleAddExpense()
    {
        int enterId = inputReader.readInt("Please Enter an ID: ");
        double enterCost = inputReader.readDouble("Please Enter the amount: ");
        String enterDescription = inputReader
                .readString("Please Enter an explanation: ");
        System.out.println("1. RENT");
        System.out.println("2. FOOD");
        System.out.println("3. TRANSPORT");
        System.out.println("4. STUDY");
        System.out.println("5. OTHER");
        int option = inputReader.readInt("Choose a category:");
        Category selectedCategory;
        switch (option)
        {
        case 1:
            selectedCategory = Category.RENT;
            break;
        case 2:
            selectedCategory = Category.FOOD;
            break;
        case 3:
            selectedCategory = Category.TRANSPORT;
            break;
        case 4:
            selectedCategory = Category.STUDY;
            break;
        case 5:
            selectedCategory = Category.OTHER;
            break;
        default:
            System.out.println("Invalid category.");
            return;

        }
        Expense newExpense = new Expense(enterId, enterCost, enterDescription,
                selectedCategory);
        expenseManager.addExpense(newExpense);
        System.out.println("Expense added successfully.");
    }

    /**
     * Displays the available operations in the main menu.
     */
    public void printMenu()
    {
        System.out.println("===== EXPENSE MANAGER =====");
        System.out.println("1. Add expense");
        System.out.println("2. Show all expenses");
        System.out.println("3. Find expense by ID");
        System.out.println("4. Remove expense");
        System.out.println("5. Show total cost");
        System.out.println("6. Show largest expense");
        System.out.println("7. Show expenses by category");
        System.out.println("0. Exit");
    }

    /**
     * Starts the console application and repeatedly processes user selections
     * until the exit option is chosen.
     */
    public void start()
    {
        boolean running = true;
        while (running)
        {
            printMenu();
            int option = inputReader.readInt("Choose an option:");
            switch (option)
            {
            case 1:
                handleAddExpense();
                break;
            case 2:
                expenseManager.printAllExpenses();
                break;
            case 5:
                System.out.println(expenseManager.calculateTotalCost());
                break;
            case 3:
                handleFindExpense();
                break;
            case 4:
                handleRemoveExpense();
                break;
            case 6:
                handleFindLargestExpense();
                break;
            case 7:
                handleFindExpensesByCategory();
                break;
            case 0:
                running = false;
                System.out.println("Good bye");
                break;
            default:
                System.out.println("Invalid option");
            }
        }

    }
}
