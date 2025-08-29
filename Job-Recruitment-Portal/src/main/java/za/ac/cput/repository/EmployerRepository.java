package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
