package com.example.springservice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvocadoRepository extends MongoRepository<Avocado, String> {
}
