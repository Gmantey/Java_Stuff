import java.text.DecimalFormat;

public class Computer implements Comparable {

    final private String name;
    final private OperatingSystem operatingSystem;
    final private double price;

    public Computer(String name, OperatingSystem operatingSystem, double price) {
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.price = price;
        if (name == null || operatingSystem == null) {
            throw new NullPointerException();
        }
        if (price < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int compareTo(Computer computer) {
        if (getPrice() < computer.price) {
            return -1;
        }
        if (computer.price == getPrice()) {
            return 0;
        }
        if (getPrice() > computer.price) {
            return 1;
        }
        if (computer == null) {
            throw new NullPointerException();
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public boolean equals (Object object) {

        if (object instanceof Computer) {
            if (((Computer) object).getPrice() == this.price){
                if (((Computer) object).getName().equals(this.name)){
                    if (((Computer) object).operatingSystem == getOperatingSystem()){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public String toString() {
        DecimalFormat f = new DecimalFormat("0.00");
        String output = "Computer[" + getName() + "," + getOperatingSystem()+ ", $" + f.format(getPrice()) + "]";
        return output;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
