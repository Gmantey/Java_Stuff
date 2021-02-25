package Episode1_Problems;

/*
 Create a class that has 3 fields,
 has getters and setters for all the fields
 and 2 methods and a constructor.

 */
public class Simple_Budget {
    // fields
    private double revenue;
    private double expenses;
    private double savings;

    // Constructor
    public Simple_Budget (){

    }
    public Simple_Budget (double revenue , double expenses , double savings){
        this.revenue = revenue;
        this.expenses = expenses;
        this.savings = savings;
    }

    public static void main(String[] args) {

        Simple_Budget sm = new Simple_Budget(24.0,89.00,1782.23);

        System.out.println("Your total Income is: " + sm.net_Worth());

    }


    // Methods
    public double calcTotalIncome (){

        return getRevenue() - getExpenses();
    }
    public double net_Worth (){

        return getSavings() + getRevenue() - getExpenses();
    }


    // Getters and setters
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
