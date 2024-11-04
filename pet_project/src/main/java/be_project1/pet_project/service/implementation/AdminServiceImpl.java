package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.AdminService;
import be_project1.pet_project.entity.AdminEntity;
import be_project1.pet_project.repository.AdminRepos;
import be_project1.pet_project.service.validation.AdminServiceVal;
import be_project1.pet_project.dto.request.AdminLoginReq;
import be_project1.pet_project.dto.request.AdminCreateReq;
import be_project1.pet_project.dto.request.AdminReadReq;
import be_project1.pet_project.dto.request.AdminUpdateReq;
import be_project1.pet_project.dto.response.AdminRes;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {
    // Init
    private final AdminRepos adminRepos;
    private final AdminServiceVal adminServiceVal;

    @Autowired
    public AdminServiceImpl(
        @Qualifier("adminRepos") AdminRepos adminRepos,
        @Qualifier("adminServiceVal") AdminServiceVal adminServiceVal) {
        this.adminRepos = adminRepos;
        this.adminServiceVal = adminServiceVal;
    }
    
    // Login
    @Override
    public Object login(AdminLoginReq request) {
        AdminEntity admin = adminRepos.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("<Admin> Wrong username"));

        // Check password (assuming you have a hashed password in the database)
        if (!admin.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("<Admin> Wrong password");
        }
        
        return "<Admin> Login successful";
    }

    // Logout
    @Override
    public Object logout(int id) {
        return String.format("<Admin> Logout successful [%d]", id);
    }

    // Create
    @Override
    public Object create(AdminCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));
        
        AdminEntity newAdmin = new AdminEntity();
        newAdmin.setUsername(request.getUsername());
        newAdmin.setPassword(request.getPassword());
        newAdmin.setStatus(request.getStatus());
        newAdmin.setCreatedDate(request.getCreatedDate());
        adminRepos.save(newAdmin);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, AdminReadReq request) {

        AdminRes response = new AdminRes();
        response.setUsername(request.getUsername());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(int id, AdminUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        AdminEntity existingAdmin = adminRepos.findById(id).orElseThrow(() ->
            new RuntimeException("Admin not found with Id: " + id));
        existingAdmin.setUsername(request.getUsername() != null ? request.getUsername() : existingAdmin.getUsername());
        existingAdmin.setPassword(request.getPassword() != null ? request.getPassword() : existingAdmin.getPassword());
        existingAdmin.setStatus(request.getStatus() != null ? request.getStatus() : existingAdmin.getStatus());
        existingAdmin.setCreatedDate(request.getCreatedDate() != null ? request.getCreatedDate() : existingAdmin.getCreatedDate());
        existingAdmin.setUpdatedDate(request.getUpdatedDate() != null ? request.getUpdatedDate() : existingAdmin.getUpdatedDate());
        adminRepos.save(existingAdmin);

        return request;
    }

    // Delete
    @Override
    public Object delete(int id) {
        AdminEntity existingAdmin = adminRepos.findById(id).orElseThrow(() ->
            new RuntimeException("Admin not found with Id: " + id));
        existingAdmin.setStatus("inactive");
        adminRepos.save(existingAdmin);

        return id;
    }
}