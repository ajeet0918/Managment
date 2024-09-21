package com.example.management.Controller;


import com.example.management.Entity.Designation;
import com.example.management.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/designation")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @GetMapping
    public ResponseEntity<List<Designation>> getAllDesignations() {
        List<Designation> designations = designationService.getAllDesignations();
        return ResponseEntity.ok(designations);
    }

    @PostMapping
    public ResponseEntity<Designation> CreateDesignation(@RequestBody Designation designation){
        Designation savedDesignation = designationService.createdesigation(designation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDesignation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Designation> updateDesignation(@PathVariable Long id, @RequestBody Designation designationDetails) {
        Designation updatedDesignation = designationService.updateDesignation(id, designationDetails);
        return ResponseEntity.ok(updatedDesignation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesignation(@PathVariable Long id) {
        designationService.deleteDesignation(id);
        return ResponseEntity.noContent().build();
    }

}
