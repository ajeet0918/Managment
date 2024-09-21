package com.example.management.Repository;

import com.example.management.Entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepo extends JpaRepository<Designation, Long> {
}
