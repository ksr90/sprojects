package com.sboot.io.sproject.service;

import com.sboot.io.sproject.exception.NoSuchProductExistsException;
import com.sboot.io.sproject.exception.ProductAlreadyExistsException;
import com.sboot.io.sproject.model.Product;
import com.sboot.io.sproject.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(){
        return repo.findAll();
    }

    public String save(Product product){
        Product existingProduct = repo.findById(product.getId())
                        .orElse(null);
        if(existingProduct == null){
            repo.save(product);
            return "Product added successfully";
        }
        else
            throw new ProductAlreadyExistsException(
                    "Product already exists !!");
    }

    public Product get(Integer id){
        return repo.findById(id).orElseThrow(
                ()
                    -> new NoSuchProductExistsException("NO PRODUCT PRESENT WITH ID ="+id));
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

}
