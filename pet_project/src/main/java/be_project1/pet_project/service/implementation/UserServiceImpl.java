package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.UserService;
import be_project1.pet_project.entity.UserEntity;
import be_project1.pet_project.repository.UserRepos;
import be_project1.pet_project.service.validation.UserServiceVal;
import be_project1.pet_project.dto.request.UserLoginReq;
import be_project1.pet_project.dto.request.UserCreateReq;
import be_project1.pet_project.dto.request.UserReadReq;
import be_project1.pet_project.dto.request.UserUpdateReq;
import be_project1.pet_project.dto.response.UserRes;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    // Init
    private final UserRepos userRepos;
    private final UserServiceVal userServiceVal;

    @Autowired
    public UserServiceImpl(
        @Qualifier("userRepos") UserRepos userRepos,
        @Qualifier("userServiceVal") UserServiceVal userServiceVal) {
        this.userRepos = userRepos;
        this.userServiceVal = userServiceVal;
    }
    
    // Login
    @Override
    public Object login(UserLoginReq request) {
        return request;
    }

    // Logout
    @Override
    public Object logout(int userID) {
        return userID;
    }

    // Create
    @Override
    public Object create(UserCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));
        
        UserEntity newUser = new UserEntity();
        newUser.setUsername(request.getUsername());
        newUser.setName(request.getName());
        newUser.setStatus(request.getStatus());
        newUser.setCreatedDate(request.getCreatedDate());
        userRepos.save(newUser);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, UserReadReq request) {

        UserRes response = new UserRes();
        response.setUsername(request.getUsername());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(int userID, UserUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        UserEntity existingUser = userRepos.findById(userID).orElseThrow(() ->
            new RuntimeException("User not found with ID: " + userID));
        existingUser.setUsername(request.getUsername() != null ? request.getUsername() : existingUser.getUsername());
        existingUser.setName(request.getName() != null ? request.getName() : existingUser.getName());
        existingUser.setStatus(request.getStatus() != null ? request.getStatus() : existingUser.getStatus());
        existingUser.setUpdatedDate(Date.from(Instant.now()));
        userRepos.save(existingUser);

        return request;
    }

    // Delete
    @Override
    public Object delete(int userID) {
        return userID;
    }
}
