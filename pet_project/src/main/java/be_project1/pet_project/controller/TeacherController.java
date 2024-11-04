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
import be_project1.pet_project.service.TeacherService;
import be_project1.pet_project.dto.request.TeacherLoginReq;
import be_project1.pet_project.dto.request.TeacherCreateReq;
import be_project1.pet_project.dto.request.TeacherReadReq;
import be_project1.pet_project.dto.request.TeacherUpdateReq;

@RestController("teacherController")
@RequestMapping("/api/v1")
public class TeacherController {
    // Init
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(@Qualifier("teacherServiceImpl") TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // Login
    @PostMapping(URLConst.LOGIN_TEACHER)
    public ResponseEntity<?> login(@Validated @RequestBody TeacherLoginReq request) {
        Object response = teacherService.login(request);
        return ResponseEntity.ok(response);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT_TEACHER)
    public ResponseEntity<?> logout(@Validated @PathVariable("id") int id) {
        Object response = teacherService.logout(id);
        return ResponseEntity.ok(response);
    }

    // Create
    @PostMapping(URLConst.CREATE_TEACHER)
    public ResponseEntity<?> createTeacher(@Validated @RequestBody TeacherCreateReq request) {
        Object response = teacherService.create(request);
        return ResponseEntity.ok(response);
    }

    // Read
    @PostMapping(URLConst.READ_TEACHER)
    public ResponseEntity<?> readTeacher(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody TeacherReadReq request) {
        Object response = teacherService.read(sort, page, size, request);
        return ResponseEntity.ok(response);
    }

     // Update
    @PutMapping(URLConst.UPDATE_TEACHER)
    public ResponseEntity<?> updateTeacher(
        @Validated
        @PathVariable("id") int id,
        @RequestBody TeacherUpdateReq request) {
        Object response = teacherService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_TEACHER)
    public ResponseEntity<?> deleteTeacher(@Validated @PathVariable("id") int id) {
        Object response =  teacherService.delete(id);
        return ResponseEntity.ok(response);
    }
}
