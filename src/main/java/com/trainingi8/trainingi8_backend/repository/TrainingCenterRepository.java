package com.trainingi8.trainingi8_backend.repository;

import  com.trainingi8.trainingi8_backend.model.TrainingCenter;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Repository interface for managing TrainingCenter entities in the MongoDB database.
 * Extends the MongoRepository interface to provide CRUD operations and custom query methods.
 */
public interface TrainingCenterRepository extends MongoRepository<TrainingCenter, String> {
    /**
     * Retrieves all TrainingCenter entities from the database.
     * 
     * @return a list of all TrainingCenter entities.
     */
    @SuppressWarnings("null")
    List<TrainingCenter> findAll();
}
