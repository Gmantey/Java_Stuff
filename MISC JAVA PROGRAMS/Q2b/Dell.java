public class Dell extends Computer implements OperatingSystem {

    public Dell() {
    }

    public Dell(String name, double cost) {
        super(name, cost);
    }

    @Override
    public void loadOperatingSystem() {
        System.out.println("FIle System: EXT4");
    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Cost: $" + getCost());
    }
}
