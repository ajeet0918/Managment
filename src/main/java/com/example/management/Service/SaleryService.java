package com.example.management.Service;

import com.example.management.Entity.Salery;
import com.example.management.Repository.SaleryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleryService {
    @Autowired
    private SaleryRepo saleryRepo;

    public Salery createSalery(Salery salery) {
        return saleryRepo.save(salery);
    }
    public List<Salery> getAll() {
        return saleryRepo.findAll();
    }

    public Salery getById(Long id) {
        return saleryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Salery not found with id: " + id));
    }

    @Transactional
    public Salery updateSalery(Long id, Salery saleryDetails) {
        Salery salery = getById(id);

        salery.setAmount(saleryDetails.getAmount());
        salery.setPay_date(saleryDetails.getPay_date());

        return saleryRepo.save(salery);
    }
    public void deleteSalery(Long id) {
        if (!saleryRepo.existsById(id)) {
            throw new RuntimeException("Salery not found with id: " + id);
        }
        saleryRepo.deleteById(id);
    }
}
