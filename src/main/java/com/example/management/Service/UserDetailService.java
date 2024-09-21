package com.example.management.Service;

import com.example.management.Entity.Employe;
import com.example.management.Repository.EmployeRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final EmployeRepo employeRepo;
    public UserDetailService(EmployeRepo employeRepo) {
        this.employeRepo = employeRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load the employee from the database using the repository instance
        Employe employe = employeRepo.findByUsername(username);
        if (employe == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.withUsername(employe.getUsername())
                .password(employe.getPassword())
                .roles("EMPLOYEE")  // Assuming all users have the role "EMPLOYEE"
                .build();
    }
}
