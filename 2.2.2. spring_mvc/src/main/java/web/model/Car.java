package web.model;


public class Car {

    private String manufacturer;

    private String model;

    private String color;

    public Car(String manufacturer, String model, String color) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
