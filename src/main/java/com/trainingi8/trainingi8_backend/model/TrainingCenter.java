package com.trainingi8.trainingi8_backend.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "trainingCenters")  // MongoDB collection name
public class TrainingCenter {
    @Id
    private String id;  // MongoDB uses String for ID

    @NotBlank(message = "CenterName is mandatory")
    @Size(max = 40, message = "CenterName must be less than 40 characters")
    private String centerName;  // Name of the training center

    @NotBlank(message = "CenterCode is mandatory")
    @Size(min = 12, max = 12, message = "CenterCode must be exactly 12 characters")
    private String centerCode;  // Unique code for the training center

    @Embedded
    private Address address;  // Address of the training center

    @NotNull(message = "Student Capacity is mandatory")
    private Integer studentCapacity;  // Capacity of students the center can accommodate

    @ElementCollection
    private List<String> coursesOffered;  // List of courses offered by the center

    private Long createdOn;  // Timestamp of when the center was created

    @Email(message = "Invalid email format")
    private String contactEmail;  // Contact email for the training center

    @NotBlank(message = "ContactPhone is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "ContactPhone must be a 10-digit number")
    private String contactPhone;  // Contact phone number for the training center
}

@Embeddable
@Data
class Address {
    private String detailedAddress;  // Detailed address of the training center
    private String city;  // City where the training center is located
    private String state;  // State where the training center is located
    private String pincode;  // Pincode of the training center's location
}