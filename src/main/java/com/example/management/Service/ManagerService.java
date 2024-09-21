package com.example.management.Service;

import com.example.management.Entity.Manager;
import com.example.management.Repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepo managerRepo;

    public Manager createManager(Manager manager){
       return managerRepo.save(manager);
    }
    public List<Manager>getAll(){
     return   managerRepo.findAll();
    }
    public Manager getById(Long id){
        Optional<Manager> optionalManager = managerRepo.findById(id);
        if (optionalManager.isPresent()){
            return optionalManager.get();
        }
        throw new ResourceNotFoundException("Designation not found with id: " + id);
    }

    @Transactional
    public void deleteManager(Long id ){
        Manager manager = getById(id);
        managerRepo.delete(manager);
    }
    @Transactional
    public Manager Updatemanager(Long id , Manager managerdetails){
        Manager manager = getById(id);
        manager.setManager_name(managerdetails.getManager_name());
        manager.setDepartment(managerdetails.getDepartment());
        return managerRepo.save(manager);
    }

}
