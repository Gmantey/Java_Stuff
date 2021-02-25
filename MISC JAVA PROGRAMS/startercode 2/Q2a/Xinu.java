public class Xinu extends OperatingSystem {

    public Xinu(int version) throws NullPointerException, IllegalArgumentException {
        super("Xinu", version);
        if (version < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object object) {

        if (object instanceof Xinu) {
            if (((Xinu) object).getVersion() == this.getVersion())
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String output = " Xinu["+getVersion()+"]";
        return output;
    }
}
