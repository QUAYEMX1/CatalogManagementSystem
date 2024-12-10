package com.example.Catalog_Management_System.Repository;

import com.example.Catalog_Management_System.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByName(String name);

}
