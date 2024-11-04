package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.AdminLoginReq;
import be_project1.pet_project.dto.request.AdminCreateReq;
import be_project1.pet_project.dto.request.AdminReadReq;
import be_project1.pet_project.dto.request.AdminUpdateReq;

public interface AdminService {
    // Login
    public Object login(AdminLoginReq request);

    // Logout
    public Object logout(int id);

    // Create
    public Object create(AdminCreateReq request);

    // Read
    public Object read(String sort, int page, int size, AdminReadReq request);

     // Update
    public Object update(int id, AdminUpdateReq request);

    // Delete
    public Object delete(int id);
}
