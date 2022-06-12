package selenium.model;

public class Filter {
    private String sum;
    private String name;
    private String brand;

    public Filter(String name, String brand, String sum) {
        this.name = name;
        this.brand = brand;
        this.sum = sum;
    }

    public Filter() {
    }

    public String getSum() {return sum;}

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
}
