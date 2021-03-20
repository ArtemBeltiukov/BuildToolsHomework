package models;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Product")
public class Product {
    @XmlElement(required = true)
    private String manufacturer;
    @XmlElement(required = true)
    private String model;
    @XmlElement(name = "production_date", required = true)
    private String productionDate;
    @XmlElement(required = true)
    private String color;
    @XmlElement(required = true)
    private String price;
    @XmlElement(required = true)
    private String stockBalance;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String id;

    @Override
    public String toString() {
        return "Product{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", stockBalance='" + stockBalance + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }



    public Product() {

    }
    public Product(String manufacturer, String model, String productionDate, String color, String price, String stockBalance, String name, String id) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionDate = productionDate;
        this.color = color;
        this.price = price;
        this.stockBalance = stockBalance;
        this.name = name;
        this.id = id;
    }


}
