package be_project1.pet_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.dto.request.UserLoginReq;
import be_project1.pet_project.dto.request.UserManageReq;
import be_project1.pet_project.dto.request.UserSearchReq;
import be_project1.pet_project.dto.response.UserSearchRes;

@RestController
public class UserController {
    // Testing
    @GetMapping("/test")
    public String test() {
        return "Test endpoint is working!";
    }

    // Login user
    @PostMapping(URLConst.USER_LOGIN)
    public Object loginUser(@RequestBody UserLoginReq request) {
        // TODO Hash passwords
        request.getUsername();
        request.setPassword("NotARealPassword"); 
        return request;
    }

    // Create user
    @PostMapping(URLConst.USER_CREATE)
    public Object createUser(@RequestBody UserManageReq request) {
        // TODO Hash passwords
        request.setPassword("NotARealPassword"); 
        return request;
    }

    // Delete user
    @DeleteMapping(URLConst.USER_DELETE)
    public Object deleteUser(@PathVariable("user_id") String userID) { 
        return "User " + userID + " deleted!";
    }

     // Update user
    @PutMapping(URLConst.USER_UPDATE)
    public Object updateUser(@PathVariable("user_id") String userID,  @RequestBody UserManageReq request) { 
        return request;
    }

    // Search user
    @PostMapping(URLConst.USER_SEARCH)
    public Object searchUser(@RequestParam("sort") String sort,
                             @RequestParam("page") int page,
                             @RequestParam("size") int size,
                             @RequestBody UserSearchReq request) {

        UserSearchRes response = new UserSearchRes();

        response.setUsername(request.getUsername());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }
}
