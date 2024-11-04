package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.TeacherService;
import be_project1.pet_project.entity.TeacherEntity;
import be_project1.pet_project.repository.TeacherRepos;
import be_project1.pet_project.service.validation.TeacherServiceVal;
import be_project1.pet_project.dto.request.TeacherLoginReq;
import be_project1.pet_project.dto.request.TeacherCreateReq;
import be_project1.pet_project.dto.request.TeacherReadReq;
import be_project1.pet_project.dto.request.TeacherUpdateReq;
import be_project1.pet_project.dto.response.TeacherRes;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
    // Init
    private final TeacherRepos teacherRepos;
    private final TeacherServiceVal teacherServiceVal;

    @Autowired
    public TeacherServiceImpl(
        @Qualifier("teacherRepos") TeacherRepos teacherRepos,
        @Qualifier("teacherServiceVal") TeacherServiceVal teacherServiceVal) {
        this.teacherRepos = teacherRepos;
        this.teacherServiceVal = teacherServiceVal;
    }
    
    // Login
    @Override
    public Object login(TeacherLoginReq request) {
        TeacherEntity teacher = teacherRepos.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("<Teacher> Wrong username"));

        // Check password (assuming you have a hashed password in the database)
        if (!teacher.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("<Teacher> Wrong password");
        }
        
        return "<Teacher> Login successful";
    }

    // Logout
    @Override
    public Object logout(int id) {
        return String.format("<Teacher> Logout successful [%d]", id);
    }

    // Create
    @Override
    public Object create(TeacherCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));
        
        TeacherEntity newTeacher = new TeacherEntity();
        newTeacher.setUsername(request.getUsername());
        newTeacher.setPassword(request.getPassword());
        newTeacher.setName(request.getName());
        newTeacher.setStatus(request.getStatus());
        newTeacher.setCreatedDate(request.getCreatedDate());
        teacherRepos.save(newTeacher);

        return newTeacher;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, TeacherReadReq request) {

        TeacherRes response = new TeacherRes();
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
    public Object update(int id, TeacherUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        TeacherEntity existingTeacher = teacherRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("Teacher not found [%d]", id)));
        existingTeacher.setUsername(request.getUsername() != null ? request.getUsername() : existingTeacher.getUsername());
        existingTeacher.setPassword(request.getPassword() != null ? request.getPassword() : existingTeacher.getPassword());
        existingTeacher.setName(request.getName() != null ? request.getName() : existingTeacher.getName());
        existingTeacher.setStatus(request.getStatus() != null ? request.getStatus() : existingTeacher.getStatus());
        existingTeacher.setCreatedDate(request.getCreatedDate() != null ? request.getCreatedDate() : existingTeacher.getCreatedDate());
        existingTeacher.setUpdatedDate(request.getUpdatedDate() != null ? request.getUpdatedDate() : existingTeacher.getUpdatedDate());
        teacherRepos.save(existingTeacher);

        return existingTeacher;
    }

    // Delete
    @Override
    public Object delete(int id) {
        TeacherEntity existingTeacher = teacherRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("Teacher not found [%d]", id)));
        existingTeacher.setStatus("inactive");
        teacherRepos.save(existingTeacher);

        return existingTeacher;
    }
}
