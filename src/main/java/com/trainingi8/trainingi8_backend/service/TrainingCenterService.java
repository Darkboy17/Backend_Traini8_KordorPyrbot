package com.trainingi8.trainingi8_backend.service;

import com.trainingi8.trainingi8_backend.model.TrainingCenter;
import com.trainingi8.trainingi8_backend.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Creates a new TrainingCenter and saves it to the repository.
     * 
     * @param trainingCenter The TrainingCenter object to be created.
     * @return The saved TrainingCenter object.
     */
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        trainingCenter.setCreatedOn(System.currentTimeMillis());
        return repository.save(trainingCenter);
    }

    /**
     * Retrieves all TrainingCenters that match the given filters.
     * 
     * @param city The city to filter by.
     * @param state The state to filter by.
     * @param coursesOffered The list of courses to filter by.
     * @return A list of TrainingCenters that match the filters.
     */
    public List<TrainingCenter> getAllTrainingCenters(String city, String state, List<String> coursesOffered) {
        Query query = new Query();

        // Add filters if parameters are provided
        if (city != null) {
            query.addCriteria(Criteria.where("address.city").is(city));
        }
        if (state != null) {
            query.addCriteria(Criteria.where("address.state").is(state));
        }
        if (coursesOffered != null && !coursesOffered.isEmpty()) {
            query.addCriteria(Criteria.where("coursesOffered").all(coursesOffered));
        }

        // Execute the query and return the results
        return mongoTemplate.find(query, TrainingCenter.class);
    }
}