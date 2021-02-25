
/*
Prompt:
        Create a class that has 3 fields,
        has getters and setters for all the fields
        and 2 methods and constructor.
 */

public class BudgetApp {

    // fields
    private double revenue;
    private double expenses;
    private double savings;

    //Constructor
    public BudgetApp(double revenue, double expenses, double savings) {
        this.revenue = revenue;
        this.expenses = expenses;
        this.savings = savings;
    }

    public BudgetApp() {
    }

    public BudgetApp(double expenses) {
        this.expenses = expenses;
    }


    // Main Method
    public static void main(String[] args) {

    }

    //Methods
    public double calcTotalIncome(){
        return getRevenue() - getExpenses();
    }
    public double netWorth(){
        return getSavings() + getRevenue() - getExpenses();
    }

    //Getters and Setters
    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }
}
