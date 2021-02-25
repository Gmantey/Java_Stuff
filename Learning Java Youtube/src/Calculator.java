public class Calculator {
    //fields
    private double preSum;
    private double totalSum;

    // constructor


    public Calculator(double preSum, double totalSum) {
        this.preSum = preSum;
        this.totalSum = totalSum;
    }
    public Calculator() {
    }

    // Main Method
    public static void main(String[] args) {

    }

    //Methods
   public double add (int a , int b){
        setPreSum(a + b);
        this.totalSum += getPreSum();
        return getPreSum();
   }
   public double multiply(int a , int b){
        setPreSum(a * b);
        this.totalSum += getPreSum();
        return a * b;
   }
    public double divide(int a , int b){
        setPreSum(a / b);
        this.totalSum += getPreSum();
        return a / b;
    }
    public double mod (int a , int b){
        setPreSum(a % b);
        this.totalSum += getPreSum();
        return a % b;
    }



    // Getters and Setters
    public double getPreSum() {
        return preSum;
    }

    public void setPreSum(double preSum) {
        this.preSum = preSum;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }
}
