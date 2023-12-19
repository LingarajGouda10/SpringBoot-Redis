package com.ivoyant.Redis.Service;

import com.ivoyant.Redis.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductService {
    private static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate<String, Object> template;


    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Object> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Object findProductById(int id) {
        System.out.println("called findProductById() from DB");
        return  template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProductById(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Product Deleted Successfully";
    }

}
