package com.example.management.Service;


import com.example.management.Entity.Employe;
import com.example.management.Repository.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepo employeRepo;

    public Employe createEmploye(Employe employe1){
        return employeRepo.save(employe1);
    }

    public Employe findByUsername(String username) {
        return employeRepo.findByUsername(username);
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerEmploye(Employe employe) {
        employe.setPassword(passwordEncoder.encode(employe.getPassword()));
    }

    public List<Employe> getAll(){
        return employeRepo.findAll();
    }

public Employe getById(Long id){
    Optional<Employe> optionalEmploye = employeRepo.findById(id);
    if (optionalEmploye.isPresent()){
        return optionalEmploye.get();
    }
    throw new ResourceNotFoundException("Designation not found with id: " + id);
}

    @Transactional
    public void DeletEmploye(Long id){
        Employe employe = getById(id);
        employeRepo.delete(employe);
    }

    @Transactional

    public Employe updateEmploye(Long id , Employe employeDetails){
        Employe employe = getById(id );
        employe.setFirstName(employeDetails.getFirstName());
        employe.setLastName(employeDetails.getLastName());
        employe.setDateOfJoining(employeDetails.getDateOfJoining());
        employe.setContactInfo(employeDetails.getContactInfo());
        employe.setDepartment(employeDetails.getDepartment());
        employe.setDesignation(employeDetails.getDesignation());
        employe.setManager(employeDetails.getManager());
        return employeRepo.save(employe);
    }
}
