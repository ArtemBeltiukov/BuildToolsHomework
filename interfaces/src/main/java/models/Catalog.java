package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {

    @XmlElement(name = "category")
    List<Category> categories = new ArrayList<>();
    public List<Category> getCategories() {
        return categories;
    }

    public Catalog() {
    }

    public Catalog(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    @Override
    public String toString() {

        return "Catalog{" +
                "categories=" + categories +
                '}';
    }
}
