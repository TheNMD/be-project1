package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import be_project1.pet_project.service.AdminService;
import be_project1.pet_project.dto.request.AdminLoginReq;
import be_project1.pet_project.dto.request.AdminCreateReq;
import be_project1.pet_project.dto.request.AdminReadReq;
import be_project1.pet_project.dto.request.AdminUpdateReq;
import be_project1.pet_project.dto.response.AdminRes;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {
    // Login
    @Override
    public Object login(AdminLoginReq request) {
        return request;
    }

    // Logout
    @Override
    public Object logout(String adminID) {
        return adminID;
    }

    // Create
    @Override
    public Object create(AdminCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

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
    public Object update(String adminID, AdminUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(String adminID) {
        return adminID;
    }
}
