package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employer;
import za.ac.cput.domain.JobListing;
import za.ac.cput.service.EmployerService;
import za.ac.cput.service.JobListingService;

@RestController
@RequestMapping("/api/joblistings")
public class JobListingController {
    @Autowired
    private JobListingService jobListingService;

    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<JobListingDTO> getAllJobListings() {
        List<JobListing> jobListings = jobListingService.getAllJobListings();
        return jobListings.stream().map(job -> {
            JobListingDTO dto = new JobListingDTO();
            dto.id = job.getJobId();
            dto.title = job.getTitle();
            dto.description = job.getDescription();
            dto.location = job.getLocation();
            dto.salary = job.getSalary();
            dto.employmentType = job.getEmploymentType();
            dto.isActive = job.isActive();
            return dto;
        }).toList();
    }

    @GetMapping("/{id}")
    public Optional<JobListing> getJobListingById(@PathVariable Long id) {
        return jobListingService.getJobListingById(id);
    }

    // DTO for job posting
    public static class JobListingDTO {
        public Long id;
        public String title;
        public String description;
        public String location;
        public String salary;
        public String employmentType;
        public boolean isActive;
    }

    @PostMapping
    public JobListing createJobListing(@RequestBody JobListingDTO dto, @RequestParam Long userId) {
        Employer employer = employerService.getEmployerById(userId).orElse(null);
        if (employer == null || !"EMPLOYER".equals(employer.getRole())) {
            throw new IllegalArgumentException("User is not an employer");
        }
        JobListing jobListing = JobListing.builder()
                .title(dto.title)
                .description(dto.description)
                .location(dto.location)
                .salary(dto.salary)
                .employmentType(dto.employmentType)
                .isActive(dto.isActive)
                .postedDate(java.time.LocalDateTime.now())
                .employer(employer)
                .build();
        return jobListingService.saveJobListing(jobListing);
    }

    @DeleteMapping("/{id}")
    public void deleteJobListing(@PathVariable Long id) {
        jobListingService.deleteJobListing(id);
    }
}
