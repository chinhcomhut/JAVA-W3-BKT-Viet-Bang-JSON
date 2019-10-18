package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProduct();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteByid(String id);

    List<Product> searchProductByName(String name);
}
