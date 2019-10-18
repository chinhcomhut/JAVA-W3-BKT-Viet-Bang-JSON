package vn.codegym.controller;

import vn.codegym.model.Product;
import vn.codegym.service.ProductService;
import vn.codegym.service.ProductServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductController {
    private ProductService productService = new ProductServiceImpl();
    public void displayProduct(){
        List<Product> listProduct = productService.getAllProduct();
        for (Product product : listProduct){
            System.out.println(product);
        }
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public void updateProductById(Product product) {
        productService.updateProduct(product);
    }

    public void deleteById(String id) {
        productService.deleteByid(id);
    }
    public List<Product> searchProductByName(String name) {
        return productService.searchProductByName(name);
    }

    public List<Product> sortByPriceASC() {
        List<Product> lst = productService.getAllProduct();
        Collections.sort(lst, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                Integer price1 = Integer.valueOf(o1.getPrice());
                Integer price2 = Integer.valueOf(o2.getPrice());
                return price1-price2;
            }
        });
        return lst;
    }

    public List<Product> sortByPriceDES() {
        List<Product> lst = productService.getAllProduct();
        Collections.sort(lst, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                Integer price1 = Integer.valueOf(o1.getPrice());
                Integer price2 = Integer.valueOf(o2.getPrice());
                return price2 - price1;
            }
        });
        return lst;
    }
}
