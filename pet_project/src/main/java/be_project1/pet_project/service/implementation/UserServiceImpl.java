package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.UserService;
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
    private static UserRepos userRepos;
    private static UserServiceVal userServiceVal;

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
    public Object logout(String userID) {
        return userID;
    }

    // Create
    @Override
    public Object create(UserCreateReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

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
    public Object update(String userID, UserUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    // Delete
    @Override
    public Object delete(String userID) {
        return userID;
    }
}
