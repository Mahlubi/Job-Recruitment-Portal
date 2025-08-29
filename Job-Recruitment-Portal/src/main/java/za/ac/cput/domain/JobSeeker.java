package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_seekers")
public class JobSeeker extends User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long jobSeekerID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String profileSummary;

    @OneToOne(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private Resume resume;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications = new ArrayList<>();

    // === Default constructor for JPA ===
    protected JobSeeker() {
    }

    private JobSeeker(Builder builder) {
        this.jobSeekerID = builder.jobSeekerID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.address = builder.address;
        this.profileSummary = builder.profileSummary;
        this.resume = builder.resume;
        this.applications = builder.applications;
    }

    // === Getters ===
    public Long getJobSeekerID() {
        return jobSeekerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getProfileSummary() {
        return profileSummary;
    }

    public Resume getResume() {
        return resume;
    }

    public List<Application> getApplications() {
        return applications;
    }

    // === toString ===
    @Override
    public String toString() {
        return "JobSeeker{" +
                "jobSeekerID=" + getJobSeekerID() + '\n' +
                ", firstName='" + getFirstName() + '\n' +
                ", lastName='" + getLastName() + '\n' +
                ", phone='" + getPhone() + '\n' +
                ", address='" + getAddress() + '\n' +
                ", profileSummary='" + getProfileSummary() + '\n' +
                ", resume=" + (resume != null ? resume.toString() : "null") + '\n' +
                ", applications=" + getApplications() + '\n' +
                '}';
    }

    // === Builder Pattern ===
    public static class Builder {
        private Long jobSeekerID;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private String profileSummary;
        private Resume resume;
        private List<Application> applications = new ArrayList<>();

        public Builder setJobSeekerID(Long jobSeekerID) {
            this.jobSeekerID = jobSeekerID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setProfileSummary(String profileSummary) {
            this.profileSummary = profileSummary;
            return this;
        }

        public Builder setResume(Resume resume) {
            this.resume = resume;
            return this;
        }

        public Builder setApplications(List<Application> applications) {
            this.applications = applications;
            return this;
        }

        public Builder copy(JobSeeker jobSeeker) {
            this.jobSeekerID = jobSeeker.getJobSeekerID();
            this.firstName = jobSeeker.getFirstName();
            this.lastName = jobSeeker.getLastName();
            this.phone = jobSeeker.getPhone();
            this.address = jobSeeker.getAddress();
            this.profileSummary = jobSeeker.getProfileSummary();
            this.resume = jobSeeker.getResume();
            this.applications = jobSeeker.getApplications();
            return this;
        }

        public JobSeeker build() {
            return new JobSeeker(this);
        }
    }
}