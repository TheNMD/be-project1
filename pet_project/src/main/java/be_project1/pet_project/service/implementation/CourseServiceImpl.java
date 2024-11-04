package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.CourseService;
import be_project1.pet_project.entity.CourseEntity;
import be_project1.pet_project.entity.TeacherEntity;
import be_project1.pet_project.repository.CourseRepos;
import be_project1.pet_project.repository.TeacherRepos;
import be_project1.pet_project.service.validation.CourseServiceVal;
import be_project1.pet_project.dto.request.CourseCreateReq;
import be_project1.pet_project.dto.request.CourseReadReq;
import be_project1.pet_project.dto.request.CourseUpdateReq;
import be_project1.pet_project.dto.response.CourseRes;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
    // Init
    private final CourseRepos courseRepos;
    private final TeacherRepos teacherRepos;
    private final CourseServiceVal courseServiceVal;

    @Autowired
    public CourseServiceImpl(
        @Qualifier("courseRepos") CourseRepos courseRepos,
        @Qualifier("teacherRepos") TeacherRepos teacherRepos,
        @Qualifier("courseServiceVal") CourseServiceVal courseServiceVal) {
        this.courseRepos = courseRepos;
        this.teacherRepos = teacherRepos;
        this.courseServiceVal = courseServiceVal;
    }
    
    // Create
    @Override
    public Object create(CourseCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        int teacherId = request.getTeacherId() != 0 ? request.getTeacherId() : -1;
        TeacherEntity teacher = teacherRepos.findById(teacherId).orElseThrow(() -> new RuntimeException(String.format("Teacher not found [%d]", teacherId)));

        CourseEntity newCourse = new CourseEntity();
        newCourse.setName(request.getName());
        newCourse.setDescription(request.getDescription());
        newCourse.setStatus(request.getStatus());
        newCourse.setCreatedDate(request.getCreatedDate());
        newCourse.setTeacherObj(teacher);
        courseRepos.save(newCourse);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, CourseReadReq request) {
        CourseRes response = new CourseRes();
        response.setCourseName(request.getName());
        response.setDescription(request.getDescription());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(int id, CourseUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));
        
        int teacherId = request.getTeacherId() != 0 ? request.getTeacherId() : -1;
        TeacherEntity teacher = (teacherId != -1) ? teacherRepos.findById(teacherId).orElseThrow(() -> new RuntimeException(String.format("Teacher not found [%d]", teacherId))) : null;

        CourseEntity existingCourse = courseRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("Course not found [%d]", id)));
        existingCourse.setName(request.getName() != null ? request.getName() : existingCourse.getName());
        existingCourse.setDescription(request.getDescription() != null ? request.getDescription() : existingCourse.getDescription());
        existingCourse.setStatus(request.getStatus() != null ? request.getStatus() : existingCourse.getStatus());
        existingCourse.setCreatedDate(request.getCreatedDate() != null ? request.getCreatedDate() : existingCourse.getCreatedDate());
        existingCourse.setUpdatedDate(request.getUpdatedDate() != null ? request.getUpdatedDate() : existingCourse.getUpdatedDate());
        existingCourse.setTeacherObj(teacher != null ? teacher : existingCourse.getTeacherObj());
        courseRepos.save(existingCourse);

        return existingCourse;
    }

    // Delete
    @Override
    public Object delete(int id) {
        CourseEntity existingCourse = courseRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("Course not found [%d]", id)));
        existingCourse.setStatus("inactive");
        courseRepos.save(existingCourse);

        return existingCourse;
    }
}
