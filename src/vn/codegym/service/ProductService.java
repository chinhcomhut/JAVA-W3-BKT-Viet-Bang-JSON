package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteByid(String id);

    List<Product> searchProductByName(String name);

    List<Product> getAllProduct();
}
