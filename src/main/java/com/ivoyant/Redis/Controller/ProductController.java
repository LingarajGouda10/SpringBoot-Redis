package com.ivoyant.Redis.Controller;

import com.ivoyant.Redis.Entity.Product;
import com.ivoyant.Redis.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCaching
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {

        return productService.save(product);
    }

    @GetMapping
    public List<Object> getAllProduct() {
        return productService.findAll();
    }

    @Cacheable(key = "#id",value = "Product",unless = "#result.price > 20000")
    @GetMapping("/{id}")
    public Object getProductOnId(@PathVariable int id) {

        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "Product")
    public String delete(@PathVariable int id) {

        return productService.deleteProductById(id);
    }

}
