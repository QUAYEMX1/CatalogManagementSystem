package com.example.Catalog_Management_System.Service;

import com.example.Catalog_Management_System.Enum.Category;
import com.example.Catalog_Management_System.Exceptions.BrandNotAvailable;
import com.example.Catalog_Management_System.Exceptions.CategoryUnavalaible;
import com.example.Catalog_Management_System.Exceptions.InvalidProductId;
import com.example.Catalog_Management_System.Models.Product;
import com.example.Catalog_Management_System.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(ProductService.class);


    public String CreateProduct(Product product) {
        logger.info("start Adding product");
        product.setCreatedOn(new Date());
        product.setUpdatedOn(new Date());
        productRepository.save(product);
        logger.info("Product added successfully");
        return "Product added successfully";
    }

   public Product getProductById(Integer id){
       logger.info("Fetching product by Id");
        Optional<Product>productOptional=productRepository.findById(id);
       if(productOptional.isEmpty()){
           throw new InvalidProductId("sorry Product Id is invalid");
       }

      Product product=productOptional.get();
       logger.info("product fetched successfully");
       return product;
   }

    public List<Product> getProductByBrand(String brand) {
        logger.info("list all product by brand name ");
        List<Product> productList = productRepository.findAll();
        List<Product> products = new ArrayList<>();

        for (Product product1 : productList) {
            if (product1.getBrand().equals(brand)) {
                products.add(product1);
            }
        }

        if (products.isEmpty()) {
            throw new BrandNotAvailable("Sorry brand is not available");
        }
        logger.info("all the product has been listed successfully");
        return products;
    }


    public List<Product> getProductByCategory(Category category){
        logger.info("GetProductByCategory method has been called");
        List<Product>productList=productRepository.findAll();
        List<Product>products=new ArrayList<>();

        for(Product product:productList){
            if(product.getCategory().equals(category)){
                products.add(product);
            }
        }
        if (products.isEmpty()) {
            throw new CategoryUnavalaible("!Sorry This Category is not found");
        }
        logger.info("GetProductByCategory method has been ended");
        return products;
    }


    public String updateProductById(int productId, Product product){
        logger.info("UpdateProductById method has been called");
         Optional<Product>optionalProduct=productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductId("sorry Product Id is invalid");
        }

        Product product1=optionalProduct.get();
        product1.setBrand(product.getBrand());
        product1.setName(product.getName());
        product1.setCategory(product.getCategory());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        product1.setDescription(product.getDescription());
        product1.setCreatedOn(product1.getCreatedOn());
        product1.setUpdatedOn(new Date());
        productRepository.save(product1);
        logger.info("UpdateProductById method has been ended");

        return "Product is updated Successfully";
    }


    public String updateProductByName(String name, Product product) throws Exception {
        Optional<Product> product2= productRepository.findByName(name);
        if (product2.isEmpty()) {
            throw new RuntimeException(String.format("Product with name %s is not available", name));
        }

        Product product1=product2.get();

        logger.info("UpdateProductByName method has been called");
        product1.setBrand(product.getBrand());
        product1.setName(product.getName());
        product1.setCategory(product.getCategory());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        product1.setDescription(product.getDescription());
        product1.setUpdatedOn(new Date()); // Keep createdOn as is
        productRepository.save(product1);  // Save the updated product
        logger.info("UpdateProductByName method has been ended");
        return "Details updated successfully";
    }




    public void deleteProduct(Integer id) {

        Optional<Product>optionalProduct=productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductId("sorry Product Id is invalid");
        }
        productRepository.deleteById(id);

    }
}
