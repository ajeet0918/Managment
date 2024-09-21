package com.example.management.Repository;

import com.example.management.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Long> {
}
