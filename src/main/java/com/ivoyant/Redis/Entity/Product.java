package com.ivoyant.Redis.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product implements Serializable {

    private String name;
    @Id
    private int id;
    private int quantity;
    private double price;


}
