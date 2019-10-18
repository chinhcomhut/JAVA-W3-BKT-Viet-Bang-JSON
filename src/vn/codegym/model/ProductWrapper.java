package vn.codegym.model;

public class ProductWrapper {
    private Product product;

    public ProductWrapper(Product p) {
        this.product = p;
    }

    public ProductWrapper() {
    }

    @Override
    public String toString() {
        return "ProductWrapper{" +
                "product=" + product +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
