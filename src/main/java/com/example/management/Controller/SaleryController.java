package com.example.management.Controller;
import com.example.management.Entity.Salery;
import com.example.management.Service.SaleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salery")
public class SaleryController {
    @Autowired
    private SaleryService saleryService;

    @GetMapping
    public ResponseEntity<List<Salery>> getAll(){
        List<Salery> salery = saleryService.getAll();
        return ResponseEntity.ok(salery);
    }

    @PostMapping
    public ResponseEntity<Salery> Createsalery(@RequestBody Salery salery){
        Salery savedSalery = saleryService.createSalery(salery);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSalery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salery> updatealery(@PathVariable Long id , Salery saleryDetails){
        Salery updatedSalery = saleryService.updateSalery(id, saleryDetails);
        return ResponseEntity.ok(updatedSalery);
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<Salery> deleteSalery(@PathVariable Long id){
      saleryService.deleteSalery(id);
        return ResponseEntity.noContent().build();
    }


}
