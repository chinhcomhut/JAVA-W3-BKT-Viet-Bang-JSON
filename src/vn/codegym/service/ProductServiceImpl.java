package vn.codegym.service;

import vn.codegym.model.Product;
import vn.codegym.repository.ProductRepository;
import vn.codegym.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository repo = new ProductRepositoryImpl();

    @Override
    public void addProduct(Product product) {
        repo.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        repo.updateProduct(product);
    }

    @Override
    public void deleteByid(String id) {
        repo.deleteByid(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return repo.searchProductByName(name);
    }

    @Override
    public List<Product> getAllProduct() {
        return  repo.getAllProduct();
    }


}
