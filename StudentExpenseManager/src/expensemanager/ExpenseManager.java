/**
 * 
 */
package expensemanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of expenses. Provides operations for adding, removing,
 * searching, displaying, and calculating information about expenses.
 */
public class ExpenseManager
{

    // Stores all expenses managed by this object.
    private List<Expense> expenses = new ArrayList<>();

    /**
     * Adds an expense to the collection.
     *
     * @param e the expense to add
     */
    public void addExpense(Expense e)
    {
        expenses.add(e);
    }

    /**
     * Removes the specified expense from the collection.
     *
     * @param e the expense to remove
     */
    public void removeExpense(Expense e)
    {
        expenses.remove(e);
    }

    /**
     * Prints the information of all registered expenses.
     */
    public void printAllExpenses()
    {
        for (Expense e : expenses)
        {
            e.printInfo();
            System.out.println();
        }
    }

    /**
     * Calculates the total cost of all registered expenses.
     *
     * @return the sum of all expense amounts
     */
    public double calculateTotalCost()
    {
        double totalCost = 0;
        for (Expense e : expenses)
        {
            totalCost += e.getCost();
        }
        return totalCost;

    }

    /**
     * Searches for an expense with the specified ID.
     *
     * @param id the ID of the expense to find
     * @return the matching expense, or {null} if no expense was found
     */
    public Expense findExpenseById(int id)
    {
        for (Expense e : expenses)
        {
            if (id == e.getId())
            {
                return e;
            }
        }
        return null;
    }

    /**
     * Removes the expense with the specified ID.
     *
     * @param id the ID of the expense to remove
     * @return {@code true} if the expense was removed; {@code false} if no
     *         matching expense was found
     */
    public boolean removeExpenseById(int id)
    {
        Expense foundExpense = findExpenseById(id);
        if (foundExpense == null)
        {
            return false;
        } else
        {
            removeExpense(foundExpense);
            return true;
        }
    }

    /**
     * Finds the expense with the highest cost.
     *
     * @return the largest expense, or {@code null} if the collection is empty
     */
    public Expense findLargestExpense()
    {
        if (expenses.isEmpty())
        {
            return null;
        }
        Expense maxExpense = expenses.get(0);
        double maxCost = expenses.get(0).getCost();
        for (Expense e : expenses)
        {
            if (e.getCost() > maxCost)
            {
                maxExpense = e;
                maxCost = e.getCost();
            }
        }
        return maxExpense;

    }

    /**
     * Finds all expenses belonging to the specified category.
     *
     * @param category the category used to filter the expenses
     * @return a list containing all matching expenses; an empty list if no
     *         matching expenses were found
     */
    public List<Expense> findExpenseByCategory(Category category)
    {
        List<Expense> foundByCategory = new ArrayList<>();
        for (Expense e : expenses)
        {
            if (e.getCategory() == category)
            {
                foundByCategory.add(e);
            }
        }
        return foundByCategory;
    }

}
