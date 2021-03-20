package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlAttribute
    private String name;
    @XmlElement(name = "subCategory")
    List<SubCategory> subCategories;

    public Category(String name, List<SubCategory> subCategories) {
        this.name = name;
        this.subCategories = subCategories;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public List<SubCategory> getSubCategory() {
        return subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", subCategory=" + subCategories +
                '}';
    }



}
