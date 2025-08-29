package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.service.JobSeekerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;


    @GetMapping
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerService.getAllJobSeekers();
    }

    @GetMapping("/{id}")
    public Optional<JobSeeker> getJobSeekerById(@PathVariable Long id) {
        return jobSeekerService.getJobSeekerById(id);
    }

    @PostMapping
    public JobSeeker createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        jobSeeker.setRole("JOB_SEEKER");
        return jobSeekerService.saveJobSeeker(jobSeeker);
    }

    @DeleteMapping("/{id}")
    public void deleteJobSeeker(@PathVariable Long id) {
        jobSeekerService.deleteJobSeeker(id);
    }
}
