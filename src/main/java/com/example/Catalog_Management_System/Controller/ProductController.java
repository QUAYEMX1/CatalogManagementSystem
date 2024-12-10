package com.example.Catalog_Management_System.Controller;

import com.example.Catalog_Management_System.Enum.Category;
import com.example.Catalog_Management_System.Models.Product;
import com.example.Catalog_Management_System.Repository.ProductRepository;
import com.example.Catalog_Management_System.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Product/Api")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(ProductController.class);


    @PostMapping("/addProduct")
    public ResponseEntity<String> CreateProduct(@RequestBody Product product) {
        logger.info("start adding product");
       String res = productService.CreateProduct(product);
        logger.info("Product added successfully");
       return new ResponseEntity<>(res,HttpStatus.CREATED);
   }

   @GetMapping("/getProduct")
    public ResponseEntity<Product> getProductById(@RequestParam("id")Integer id){
       logger.info("fetching product from id");
         Product product=productService.getProductById(id);
       logger.info("Product find successfully");
         return new ResponseEntity<>(product,HttpStatus.OK);
   }

    @GetMapping("/getProductByBrand")
    public ResponseEntity<List<Product>> getProductsByBrand(@RequestParam("brand")String brand) {
        logger.info("fetching all product with given brand");
       List<Product> res=productService.getProductByBrand(brand);
        logger.info("getProductByBrand API successful");
       return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @GetMapping("/getProductByCategory")
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam("category")Category category) {
        // Log the start of the API call
        logger.info("fetching all product with given category");
        List<Product> res = productService.getProductByCategory(category);
        logger.info("getProductByCategory API successful");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/updateById")
    public ResponseEntity<String> updateProductById(@RequestParam("id") Integer productId,
                                               @RequestBody Product product) {
        logger.info("Starting update API");
       String res=productService.updateProductById(productId,product);
        logger.info("Update API successful");
       return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PutMapping("/updateByName")
    public ResponseEntity<String> updateProductByName(@RequestParam("name") String name, @RequestBody Product product) {
        logger.info("Starting updateProductByName API");
        try {
            String result = productService.updateProductByName(name, product);
            logger.info("updateProductByName API successful");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Update failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Can't update the product");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        logger.info("start deleting product from id");
        productService.deleteProduct(id);
        logger.info("product deleted successfully from the table");
        return ResponseEntity.noContent().build();
    }

}



