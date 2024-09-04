package com.example.buoi2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends MongoRepository<Home, String> {
    // List<Home> findByPublished(boolean published);
}

