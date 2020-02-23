package homework3;

public abstract class Nokia {
    private String manufactNokia;
    private String modelNokia;
    private final int nokiaBatteryLife;

    //Parent class constructor;
    protected Nokia() {
        this.nokiaBatteryLife = 24;
        this.manufactNokia = manufactNokia;
        this.modelNokia = modelNokia;
    }

    public int getNokiaBatteryLife() {
        return nokiaBatteryLife;
    }
}

