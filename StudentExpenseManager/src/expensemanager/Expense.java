/**
 * 
 */
package expensemanager;

/**
 * Represents a single expense in the expense management system. Each expense
 * has a unique ID, a cost, a description, and a category.
 */
public class Expense
{
    private int id;
    private double cost;
    private String explanation;
    private Category category;

    /**
     * Creates a new expense with the specified information.
     *
     * @param id          the unique ID of the expense
     * @param cost        the monetary amount of the expense
     * @param explanation a short description of the expense
     * @param category    the category to which the expense belongs
     */
    public Expense(int id, double cost, String explanation, Category category)
    {
        this.id = id;
        this.cost = cost;
        this.explanation = explanation;
        this.category = category;
    }

    /**
     * Returns the unique ID of this expense.
     *
     * @return the expense ID
     */
    public int getId()
    {
        return id;
    }

    /**
     * Returns the monetary amount of this expense.
     *
     * @return the expense amount
     */
    public double getCost()
    {
        return cost;
    }

    /**
     * Returns the description of this expense.
     *
     * @return the expense description
     */
    public String getExplanation()
    {
        return explanation;
    }

    /**
     * Returns the category of this expense.
     *
     * @return the expense category
     */
    public Category getCategory()
    {
        return category;
    }

    /**
     * Prints all information about this expense to the console.
     */
    public void printInfo()
    {
        System.out.println("Id: " + id);
        System.out.println("Amount: " + cost);
        System.out.println("Category: " + category);
        System.out.println("Description: " + explanation);
    }

}
