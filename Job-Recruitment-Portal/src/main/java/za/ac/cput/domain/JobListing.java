package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_listings")
public class JobListing {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long jobID;
    private String title;
    private String description;
    private String location;
    private String employmentType; // e.g. FULL_TIME, PART_TIME, CONTRACT
    private LocalDateTime postedDate;
    private boolean isActive;
    private String salary;
    // Many job listings belong to one employer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id", referencedColumnName = "employerID")
    @JsonBackReference("employer-joblisting")
    private Employer employer;

    // Default constructor for JPA
    protected JobListing() {
    }

    private JobListing(Builder builder) {
        this.jobID = builder.jobID;
        this.title = builder.title;
        this.description = builder.description;
        this.location = builder.location;
        this.employmentType = builder.employmentType;
        this.postedDate = builder.postedDate;
        this.isActive = builder.isActive;
        this.employer = builder.employer;
        this.salary = builder.salary;
    }

    // === Getters ===
    public Long getJobID() {
        return jobID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public boolean getIsActive() {
        return isActive;
    }
    public String getSalary() {
        return salary;
    }

    public Employer getEmployer() {
        return employer;
    }

    // === toString ===
    @Override
    public String toString() {
        return "JobListing{" +
                "jobID=" + getJobID() + '\n' +
                ", title='" + getTitle() + '\n' +
                ", description='" + getDescription() + '\n' +
                ", location='" + getLocation() + '\n' +
                ", employmentType='" + getEmploymentType() + '\n' +
                ", postedDate=" + getPostedDate() + '\n' +
                ", isActive=" + getIsActive() + '\n' +
                ", salary='" + getSalary() + '\n' +
                ", employer=" + (employer != null ? employer.getCompanyName() : "null") + '\n' +
                '}';
    }

    // === Builder Pattern ===
    public static class Builder {
        private Long jobID;
        private String title;
        private String description;
        private String location;
        private String employmentType;
        private LocalDateTime postedDate;
        private boolean isActive;
        private Employer employer;
        private String salary;

        public Builder setJobID(Long jobID) {
            this.jobID = jobID;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setEmploymentType(String employmentType) {
            this.employmentType = employmentType;
            return this;
        }

        public Builder setPostedDate(LocalDateTime postedDate) {
            this.postedDate = postedDate;
            return this;
        }

        public Builder setIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder setEmployer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public Builder setSalary(String salary) {
            this.salary = salary;
            return this;
        }

        public Builder copy(JobListing jobListing) {
            this.jobID = jobListing.getJobID();
            this.title = jobListing.getTitle();
            this.description = jobListing.getDescription();
            this.location = jobListing.getLocation();
            this.employmentType = jobListing.getEmploymentType();
            this.postedDate = jobListing.getPostedDate();
            this.isActive = jobListing.getIsActive();
            this.salary = jobListing.getSalary();
            this.employer = jobListing.getEmployer();
            return this;
        }

        public JobListing build() {
            return new JobListing(this);
        }

    }
}
