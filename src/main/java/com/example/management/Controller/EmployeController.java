package com.example.management.Controller;


import com.example.management.Entity.Employe;
import com.example.management.Service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/employe")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @GetMapping
    public ResponseEntity<List<Employe>> getAll(){
        List<Employe> employs = employeService.getAll();
        return ResponseEntity.ok(employs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getByIdl(@PathVariable Long id){
       Employe employ = employeService.getById(id);
        return ResponseEntity.ok(( employ));
    }

    @GetMapping("/employee/profile")
    public String viewProfile(Model model, Principal principal) {
        String username = principal.getName();
        Employe employe = employeService.findByUsername(username);
        model.addAttribute("employe", employe);
        return "employeeProfile";
    }
    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe){
        Employe savedEmploye = employeService.createEmploye(employe);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmploye);
    }

@PutMapping("/{id}")
public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employeDetails) {
    Employe updatedEmploye = employeService.updateEmploye(id, employeDetails);
    return ResponseEntity.ok(employeDetails);
}

@DeleteMapping("/{id}")

    public ResponseEntity<Employe> DeleteEmploye(@PathVariable Long id){
        employeService.DeletEmploye(id);
    return ResponseEntity.noContent().build();
}

}