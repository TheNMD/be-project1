package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.TeacherLoginReq;
import be_project1.pet_project.dto.request.TeacherCreateReq;
import be_project1.pet_project.dto.request.TeacherReadReq;
import be_project1.pet_project.dto.request.TeacherUpdateReq;

public interface TeacherService {
    // Login
    public Object login(TeacherLoginReq request);

    // Logout
    public Object logout(int userId);

    // Create
    public Object create(TeacherCreateReq request);

    // Read
    public Object read(String sort, int page, int size, TeacherReadReq request);

     // Update
    public Object update(int userId, TeacherUpdateReq request);

    // Delete
    public Object delete(int userId);
}
