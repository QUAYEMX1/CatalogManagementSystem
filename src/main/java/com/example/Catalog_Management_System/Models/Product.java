package com.example.Catalog_Management_System.Models;

import com.example.Catalog_Management_System.Enum.Category;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true, nullable = false)
    String name;

    @Column(nullable = false)
    String brand;

    String description;

    @Column(nullable = false)
    String price;

    @Column(nullable = false)
    int quantity;

    @Enumerated(value = EnumType.STRING)
    Category category;

    Date createdOn;

    Date updatedOn;

}
