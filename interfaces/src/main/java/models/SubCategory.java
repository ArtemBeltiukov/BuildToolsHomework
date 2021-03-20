package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class SubCategory {

    @XmlElement(name = "product")
    List<Product> products = new ArrayList<>();
    @XmlAttribute
    private String name;

    public SubCategory(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public SubCategory() {
    }

    public String getName() {
        return name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "name='" + name + '\'' +
                ", product=" + products +
                '}';
    }
}
