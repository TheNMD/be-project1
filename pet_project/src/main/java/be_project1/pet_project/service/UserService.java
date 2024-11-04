package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.UserLoginReq;
import be_project1.pet_project.dto.request.UserCreateReq;
import be_project1.pet_project.dto.request.UserReadReq;
import be_project1.pet_project.dto.request.UserUpdateReq;

public interface UserService {
    // Login
    public Object login(UserLoginReq request);

    // Logout
    public Object logout(int userId);

    // Create
    public Object create(UserCreateReq request);

    // Read
    public Object read(String sort, int page, int size, UserReadReq request);

     // Update
    public Object update(int userId, UserUpdateReq request);

    // Delete
    public Object delete(int userId);
}
