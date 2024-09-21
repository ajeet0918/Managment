package com.example.management.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Employe")

public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employe_id;
    @Column(name = "first_name")
    private String  firstName;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "date_of_joining")
    private LocalDate DateOfJoining;
    @Column(name = "Contact_info")
    private String ContactInfo;
    @Column(name = "department")
    private String department;
    @Column(name = ":user_name")
    private String username;
    @Column(name = "password")
    private String password;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "designation_id")
    private Designation designation;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manager_id")
    private Manager manager;

}
