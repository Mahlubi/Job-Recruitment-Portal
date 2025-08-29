package za.ac.cput.factory;

import za.ac.cput.domain.Application;
import za.ac.cput.domain.Employer;
import za.ac.cput.domain.JobListing;
import za.ac.cput.domain.Skill;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class JobListingFactory { public static JobListing createJobListing(
        String title,
        String description,
        String location,
        String salary,
        String employmentType,
        LocalDateTime postedDate,
        boolean isActive,
        Employer employer,
        List<Application> applications,
        List<Skill> skills
) {
    if (title == null || title.isEmpty()) {
        throw new IllegalArgumentException("Job title is required");
    }
    if (description == null || description.isEmpty()) {
        throw new IllegalArgumentException("Job description is required");
    }

    return new JobListing.Builder()
            .setTitle(title)
            .setDescription(description)
            .setLocation(location)
            .setSalary(salary)
            .setEmploymentType(employmentType)
            .setPostedDate(postedDate != null ? postedDate : LocalDateTime.now())
            .setIsActive(isActive)
            .setEmployer(employer)
            .build();

}

    // Optional: default JobListing for testing
    public static JobListing createDefaultJobListing() {
        return createJobListing(
                "Software Developer",
                "Develop and maintain web applications",
                "Cape Town",
                "R25,000",
                "Full-Time",
                LocalDateTime.now(),
                true,
                null, // default employer can be set if needed
                new ArrayList<>(),
                new ArrayList<>()
        );
    }
}