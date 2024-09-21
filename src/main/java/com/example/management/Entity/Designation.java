package com.example.management.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Designation")
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employe_id;
    @Column(name = "designation_name")
    private String designation_name;
    @Column(name = "department")
    private String department;



}
