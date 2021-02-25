public abstract class OperatingSystem {
    final private String name;
    final private int version;

    public OperatingSystem(String name, int version) throws NullPointerException, IllegalArgumentException {
        this.name = name;
        this.version = version;

        if (name == null) {
            throw new NullPointerException();
        }
        if (version < 0) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }
    public abstract boolean equals (Object object);
    public abstract String toString ();
}
