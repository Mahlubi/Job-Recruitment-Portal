package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.JobListing;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {
}
