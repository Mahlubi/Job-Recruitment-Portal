package za.ac.cput.domain;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.List;

@Entity
@Table(name = "administrators")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Administrator extends User {
    private Integer adminLevel;
    @ElementCollection
    private List<String> permissions;

    // Add builder methods for inherited fields
    public static class AdministratorBuilder {
        private String email;
        private String password;
        private String role;
        private LocalDateTime createdAt;
        private Integer adminLevel;
        private List<String> permissions;

        public AdministratorBuilder email(String email) {
            this.email = email;
            return this;
        }
        public AdministratorBuilder password(String password) {
            this.password = password;
            return this;
        }
        public AdministratorBuilder role(String role) {
            this.role = role;
            return this;
        }
        public AdministratorBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public AdministratorBuilder adminLevel(Integer adminLevel) {
            this.adminLevel = adminLevel;
            return this;
        }
        public AdministratorBuilder permissions(List<String> permissions) {
            this.permissions = permissions;
            return this;
        }
        public Administrator build() {
            Administrator admin = new Administrator();
            admin.setEmail(this.email);
            admin.setPassword(this.password);
            admin.setRole(this.role);
            admin.setCreatedAt(this.createdAt);
            admin.setAdminLevel(this.adminLevel);
            admin.setPermissions(this.permissions);
            return admin;
        }
    }
}

