package com.example.management.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "Salery")
public class Salery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salery_id;
    @Column(name = "pay_date")
    private LocalDate pay_date;
    @Column(name = "amount")
    private Long amount;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employe_id")
    private Employe employe;
}
