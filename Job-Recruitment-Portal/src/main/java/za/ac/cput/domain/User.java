package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED) // allows Employer and Student to extend User
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userID;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING) // Store role as VARCHAR
    private Role role;

    public enum Role {
        ADMIN,
        JOB_SEEKER,
        EMPLOYER
    }

    // === Default constructor for JPA ===
    protected User() {
    }

    private User(Builder builder) {
        this.userID = builder.userID;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    // === Getters ===
    public Long getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    // === toString ===
    @Override
    public String toString() {
        return "User{" +
                "userID=" + getUserID() + '\n' +
                ", email='" + getEmail() + '\n' +
                ", password='" + getPassword() + '\n' +
                ", role=" + getRole() + '\n' +
                '}';
    }

    // === Builder Pattern ===
    public static class Builder {
        private Long userID;
        private String email;
        private String password;
        private Role role;

        public Builder setUserID(Long userID) {
            this.userID = userID;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder copy(User user) {
            this.userID = user.getUserID();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.role = user.getRole();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}