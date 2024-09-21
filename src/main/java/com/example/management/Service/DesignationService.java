package com.example.management.Service;

import com.example.management.Entity.Designation;
import com.example.management.Repository.DesignationRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Data
@Service
public class DesignationService {
@Autowired
    private DesignationRepo designationRepo;

public Designation createdesigation(Designation designation){
    return designationRepo.save(designation);
}
public Designation getDesigationById(Long id){
    Optional<Designation> optionalDesignation = designationRepo.findById(id);
    if (optionalDesignation.isPresent()) {
        return optionalDesignation.get();
    } else {
        throw new ResourceNotFoundException("Designation not found with id: " + id);
    }
}
    public List<Designation> getAllDesignations() {
        return designationRepo.findAll();
    }
    @Transactional
    public void deleteDesignation(Long id) {
        Designation designation = getDesigationById(id);
        designationRepo.delete(designation);
    }
    @Transactional
    public Designation updateDesignation(Long id, Designation designationDetails) {
        Designation designation = getDesigationById(id);

        designation.setDesignation_name(designationDetails.getDesignation_name());
        designation.setDepartment(designationDetails.getDepartment());

        return designationRepo.save(designation);
    }
}
