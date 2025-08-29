package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.JobListing;
import za.ac.cput.repository.JobListingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobListingService {
    @Autowired
    private JobListingRepository jobListingRepository;

    public List<JobListing> getAllJobListings() {
        return jobListingRepository.findAll();
    }

    public Optional<JobListing> getJobListingById(Long id) {
        return jobListingRepository.findById(id);
    }

    public JobListing saveJobListing(JobListing jobListing) {
        return jobListingRepository.save(jobListing);
    }

    public void deleteJobListing(Long id) {
        jobListingRepository.deleteById(id);
    }
}
