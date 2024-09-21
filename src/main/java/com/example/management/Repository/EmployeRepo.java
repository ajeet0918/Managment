package com.example.management.Repository;

import com.example.management.Entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employe, Long> {
     Employe findByUsername(String username);
}
