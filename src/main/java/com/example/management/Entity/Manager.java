package com.example.management.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manager_id;
    @Column(name = "manager_name")
    private String manager_name;
    @Column(name = "department")
    private String department;
}
