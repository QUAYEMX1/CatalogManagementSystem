package com.example.Catalog_Management_System.Repository;

import com.example.Catalog_Management_System.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Optional<Product> findByName(String name);

}
