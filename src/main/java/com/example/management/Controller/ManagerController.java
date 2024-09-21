package com.example.management.Controller;


import com.example.management.Entity.Manager;
import com.example.management.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;


    @GetMapping
    public ResponseEntity<List<Manager>> getAll(){
        List<Manager> managers = managerService.getAll();
        return ResponseEntity.ok(managers);
    }

    @PostMapping
    public ResponseEntity<Manager> CreateManager(@RequestBody Manager manager){
        Manager savedManager = managerService.createManager(manager);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedManager);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long id , Manager mangerDetails){
        Manager updatedManager = managerService.Updatemanager(id, mangerDetails);
        return ResponseEntity.ok(updatedManager);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Manager> deleteManager(@PathVariable Long id){
        managerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }

}
