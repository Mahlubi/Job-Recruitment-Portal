package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
}
