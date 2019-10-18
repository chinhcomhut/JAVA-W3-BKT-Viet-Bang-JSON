package vn.codegym.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import vn.codegym.model.Product;
import vn.codegym.model.ProductWrapper;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private String fileJson = "products.json";
    private Gson gson = new Gson();
    @Override
    public List<Product> getAllProduct() {
        List<Product> output = new ArrayList<>();
//        output.add(new Product(1l,"iphone", 200L));
//        output.add(new Product(1l,"iphone", 200L));

        StringBuilder sb = new StringBuilder();
        try {
            Files.lines(Paths.get(fileJson)).forEach(line->{
                sb.append(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // convert json string to list object:
        //System.out.println(">>> json input:"+sb.toString());
        Type listType = new TypeToken<ArrayList<ProductWrapper>>(){}.getType();
        List<ProductWrapper> wrapper = this.gson.fromJson(sb.toString(),listType);

        // convert product wrapper to product
        for (ProductWrapper item : wrapper){
            output.add(item.getProduct());
        }
        return output;
    }

    @Override
    public void addProduct(Product product) {
        //1. read all old data
        List<Product> allData = getAllProduct();
        //2. add to list
        allData.add(product);
        //3. overwrite to old file
        writeToFile(allData);
    }

    @Override
    public void updateProduct(Product product) {
        List<Product> listProduct = getAllProduct();
        for (Product p : listProduct){
            if (p.getId().equals(product.getId())){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
            }
        }
        // save data to FILE
        writeToFile(listProduct);
    }

    @Override
    public void deleteByid(String id) {
        List<Product> allProduct = getAllProduct();
        List<Product> allProductSeconde = new ArrayList<>();  //buffer
        for (Product p : allProduct){
            if (p.getId().equals(id)) continue;;
            allProductSeconde.add(p);
        }
        writeToFile(allProductSeconde);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> allProduct = getAllProduct();
        List<Product> listSearch = new ArrayList<>();
        for (Product p : allProduct){
            if(name!= null &&p.getName().toLowerCase().contains(name.toLowerCase())){
                listSearch.add(p);
            }
        }
        return listSearch;
    }

    private void writeToFile(List<Product> allData) {
        try(BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(new File(this.fileJson)))){
            List<ProductWrapper> productWrappers = new ArrayList<>();

            // convert product to product wraper;
            for(Product p : allData){
                productWrappers.add(new ProductWrapper(p));
            }
            String json = this.gson.toJson(productWrappers);
            bof.write(json.getBytes());
            bof.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
