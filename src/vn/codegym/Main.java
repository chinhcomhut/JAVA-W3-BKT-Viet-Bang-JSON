package vn.codegym;

import vn.codegym.controller.ProductController;
import vn.codegym.model.Product;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        //1. display list product:
        ProductController pc = new ProductController();
        pc.displayProduct();

        //2. Add product;
        pc.addProduct(new Product("2","Tivi samsung","300"));

        //3. edit product;
        pc.updateProductById(new Product("3","Tulanh + may Giat","999"));

        //4. delete
        pc.deleteById("399");

        //5. search by name:
        String name = "sung";
        List<Product> ps = pc.searchProductByName(name);
        if (ps.isEmpty()){
            System.out.println("not found product have name:"+name);
        } else{
            System.out.println(" your list search product:"+ ps +"\n by key search:"+name);
        }

        //6. sort by name

        List<Product> listSort = pc.sortByPriceASC();
        System.out.println("List product sorted ASC:"+listSort);

         listSort = pc.sortByPriceDES();
        System.out.println("List product sorted DES:"+listSort);
    }
}
