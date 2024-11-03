package be_project1.pet_project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.service.UserService;
import be_project1.pet_project.dto.request.UserLoginReq;
import be_project1.pet_project.dto.request.UserCreateReq;
import be_project1.pet_project.dto.request.UserReadReq;
import be_project1.pet_project.dto.request.UserUpdateReq;

@RestController("userController")
@RequestMapping("/api/v1")
public class UserController {
    // Init
    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    // Login
    @PostMapping(URLConst.LOGIN_USER)
    public ResponseEntity<?> login(@Validated @RequestBody UserLoginReq request) {
        Object res = userService.login(request);
        String message = "Login successful";
        return ResponseEntity.ok(message);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT_USER)
    public ResponseEntity<?> logout(@Validated @PathVariable("user_id") String userID) {
        Object res = userService.logout(userID);
        String message = "Logout successful";
        return ResponseEntity.ok(message);
    }

    // Create
    @PostMapping(URLConst.CREATE_USER)
    public ResponseEntity<?> createUser(@Validated @RequestBody UserCreateReq request) {
        Object res = userService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_USER)
    public ResponseEntity<?> readUser(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody UserReadReq request) {
        Object res = userService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

     // Update
    @PutMapping(URLConst.UPDATE_USER)
    public ResponseEntity<?> updateUser(
        @Validated
        @PathVariable("user_id") String userID,
        @RequestBody UserUpdateReq request) {
        Object res = userService.update(userID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER)
    public ResponseEntity<?> deleteUser(@Validated @PathVariable("user_id") String userID) {
        Object res =  userService.delete(userID);
        return ResponseEntity.ok(res);
    }
}
