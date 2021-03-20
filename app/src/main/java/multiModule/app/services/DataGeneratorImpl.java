package multiModule.app.services;


import interfaces.DataGenerator;
import models.Catalog;
import models.Category;
import models.Product;
import models.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class DataGeneratorImpl implements DataGenerator {
    @Override
    public Catalog generateCatalog() {
        Product product = new Product("Bosch", "AB290", "03.09.2020", "White", "46.0", "568", "Washing machine", "1");
        Product product1 = new Product("Indesit", "AB400", "03.09.2020", "White", "50.0", "570", "Washing machine", "2");
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product);
        List<Product> lightProductList = new ArrayList<>();
        lightProductList.add(new Product("Tesla", "LI130","03.09.2020","White","1.5","1000","Bulb","3"));
        List<SubCategory> subCategories = new ArrayList<>();
        subCategories.add(new SubCategory("appliances", productList));
        subCategories.add(new SubCategory("light", lightProductList));
        Category category = new Category("Electronic", subCategories);
        Catalog catalog = new Catalog();
        catalog.addCategory(category);

        return catalog;
    }
}
