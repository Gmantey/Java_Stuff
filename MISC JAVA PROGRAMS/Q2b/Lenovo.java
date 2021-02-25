public class Lenovo extends Computer implements OperatingSystem {


    public Lenovo() {
    }

    public Lenovo(String name, double cost) {
        super(name, cost);
    }

    @Override
    public void loadOperatingSystem() {
        System.out.println("File System: NTFS");

    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Cost: $" + getCost());
    }
}
