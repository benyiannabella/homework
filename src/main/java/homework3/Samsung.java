package homework3;

public abstract class Samsung {
    private String manufacturer;
    private String model;
    private final int batteryLife;

    //Parent class constructor;
    protected Samsung() {
        this.batteryLife = 4;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getBatteryLife() {
        return batteryLife;
    }
}
