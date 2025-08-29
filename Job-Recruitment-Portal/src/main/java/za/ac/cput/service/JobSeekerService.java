package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.JobListing;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.repository.JobSeekerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public Optional<JobSeeker> getJobSeekerById(Long id) {
        return jobSeekerRepository.findById(id);
    }

    public List<JobSeeker> getAllJobSeekers() {return jobSeekerRepository.findAll();}

    public void deleteJobSeeker(Long id) {jobSeekerRepository.deleteById(id);}

    public JobSeeker saveJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }
}
