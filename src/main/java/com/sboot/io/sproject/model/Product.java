package com.sboot.io.sproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private String name;
    private float price;


    /*
    public Product(){
    }
    **************need of no-argument constructor for entity class********************
    JPA requires no-argument constructor for the entity class because it uses reflection
    to instantiate entity objects when fetching them from the database. Libraries such as
    Jackson(JSON Serialization) require a no-argument constructor.

    *****************Removed the no-argument Constructor of the Product ******************
    Added NoArgsConstructor, Lombok simplifies the creation of no-argument constructors using
    the @NoArgsConstructor annotation, reducing boilerplate code.

    public Product(Integer id, String name, float price){  /// this is a constructor
        this.id = id;
        this.name = name;
        this.price = price;
    }
    ******************need of Constructor for all the fields************************
    Creating a constructor for all the fields in a model class ensures that the object
    is created in a valid state, supports immutability, simplifies object creation, and
    enhances readability and maintainability of the code. In Spring Boot applications,
    this practice aligns well with dependency injection principles, ensuring that all
    dependencies are provided at the time of object creation.

    *****************Removed the Constructor of the Product *************************
    Added @AllArgsConstructor annotation provided by Lombok, for ensuring consistency
    and supporting constructed-based dependency injection
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
