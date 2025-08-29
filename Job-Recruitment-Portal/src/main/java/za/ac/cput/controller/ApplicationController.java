package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Application;
import za.ac.cput.service.ApplicationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Optional<Application> getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.saveApplication(application);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }

    @PostMapping("/apply")
    public Application applyToJob(@RequestBody ApplyDTO dto) {
        Application application = Application.builder()
                .jobSeeker(dto.jobSeeker)
                .jobListing(dto.jobListing)
                .coverLetter(dto.coverLetter)
                .appliedDate(java.time.LocalDateTime.now())
                .status("PENDING")
                .build();
        return applicationService.saveApplication(application);
    }

    // ✅ Fixed: use @RequestParam for text/IDs, @RequestPart for file
    @PostMapping(value = "/apply-with-resume", consumes = "multipart/form-data")
    public ResponseEntity<?> applyToJobWithResume(
            @RequestParam("jobSeekerId") Long jobSeekerId,
            @RequestParam("jobListingId") Long jobListingId,
            @RequestParam(value = "coverLetter", required = false) String coverLetter,
            @RequestPart("resume") MultipartFile resumeFile) {
        try {
            // Build JobSeeker with ID only
            jobseekers.model.JobSeeker jobSeeker = new jobseekers.model.JobSeeker();
            jobSeeker.setUserId(jobSeekerId);

            // Build JobListing with ID only
            jobseekers.model.JobListing jobListing = new jobseekers.model.JobListing();
            jobListing.setJobId(jobListingId);

            // Build Application entity
            Application application = Application.builder()
                    .jobSeeker(jobSeeker)
                    .jobListing(jobListing)
                    .coverLetter(coverLetter)
                    .appliedDate(java.time.LocalDateTime.now())
                    .status("PENDING")
                    .resume(resumeFile.getBytes())
                    .build();

            applicationService.saveApplication(application);
            return ResponseEntity.ok("Application submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to submit application: " + e.getMessage());
        }
    }

    // DTO for JSON-based apply (without file)
    public static class ApplyDTO {
        public jobseekers.model.JobSeeker jobSeeker;
        public jobseekers.model.JobListing jobListing;
        public String coverLetter;
    }
}
