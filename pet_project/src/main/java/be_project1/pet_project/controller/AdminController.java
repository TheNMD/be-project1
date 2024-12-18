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
import be_project1.pet_project.service.AdminService;
import be_project1.pet_project.dto.request.AdminLoginReq;
import be_project1.pet_project.dto.request.AdminCreateReq;
import be_project1.pet_project.dto.request.AdminReadReq;
import be_project1.pet_project.dto.request.AdminUpdateReq;

@RestController("adminController")
@RequestMapping("/api/v1")
public class AdminController {
    // Init
    private final AdminService adminService;

    @Autowired
    public AdminController(@Qualifier("adminServiceImpl") AdminService adminService) {
        this.adminService = adminService;
    }

    // Login
    @PostMapping(URLConst.LOGIN_ADMIN)
    public ResponseEntity<?> login(@Validated @RequestBody AdminLoginReq request) {
        Object response = adminService.login(request);
        String message = "Login successful";
        return ResponseEntity.ok(message);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT_ADMIN)
    public ResponseEntity<?> logout(@Validated @PathVariable("id") int id) {
        Object response = adminService.logout(id);
        String message = "Logout successful";
        return ResponseEntity.ok(message);
    }

    // Create
    @PostMapping(URLConst.CREATE_ADMIN)
    public ResponseEntity<?> createAdmin(@Validated @RequestBody AdminCreateReq request) {
        Object response = adminService.create(request);
        return ResponseEntity.ok(response);
    }

    // Read
    @PostMapping(URLConst.READ_ADMIN)
    public ResponseEntity<?> readAdmin(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody AdminReadReq request
        ) {
        Object response = adminService.read(sort, page, size, request);
        return ResponseEntity.ok(response);
    }

     // Update
    @PutMapping(URLConst.UPDATE_ADMIN)
    public ResponseEntity<?> updateAdmin(
        @Validated
        @PathVariable("id") int id,
        @RequestBody AdminUpdateReq request
        ) {
        Object response = adminService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ADMIN)
    public ResponseEntity<?> deleteAdmin(@Validated @PathVariable("id") int id) {
        Object response =  adminService.delete(id);
        return ResponseEntity.ok(response);
    }
}
