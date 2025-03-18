package com.trainingi8.trainingi8_backend.controller;

import com.trainingi8.trainingi8_backend.model.TrainingCenter;
import com.trainingi8.trainingi8_backend.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * This class is a Spring Boot controller for handling HTTP requests related to Training Centers.
 * It provides endpoints for creating, and retrieving btraining centers.
 * 
 * The controller uses ResponseEntity to build HTTP responses.
 * 
 * @see org.springframework.http.ResponseEntity
 */
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {
    @Autowired
    private TrainingCenterService service;

    /**
     * Endpoint to create a new training center.
     * 
     * @param trainingCenter The training center object to be created.
     * @return ResponseEntity containing the created training center.
     */
    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        return ResponseEntity.ok(service.createTrainingCenter(trainingCenter));
    }

    /**
     * Endpoint to retrieve all training centers, optionally filtered by city, state, and courses offered.
     * 
     * @param city The city to filter training centers by (optional).
     * @param state The state to filter training centers by (optional).
     * @param coursesOffered The list of courses to filter training centers by (optional).
     * @return ResponseEntity containing the list of training centers.
     */
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String state,
        @RequestParam(required = false) List<String> coursesOffered
    ) {
        // Pass the query parameters to the service method
        List<TrainingCenter> trainingCenters = service.getAllTrainingCenters(city, state, coursesOffered);

        return ResponseEntity.ok(trainingCenters);
    }
}