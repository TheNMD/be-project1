package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.CourseService;
import be_project1.pet_project.entity.CourseEntity;
import be_project1.pet_project.repository.CourseRepos;
import be_project1.pet_project.service.validation.CourseServiceVal;
import be_project1.pet_project.dto.request.CourseCreateReq;
import be_project1.pet_project.dto.request.CourseReadReq;
import be_project1.pet_project.dto.request.CourseUpdateReq;
import be_project1.pet_project.dto.response.CourseRes;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
    // Init
    private final CourseRepos courseRepos;
    private final CourseServiceVal courseServiceVal;

    @Autowired
    public CourseServiceImpl(
        @Qualifier("courseRepos") CourseRepos courseRepos,
        @Qualifier("courseServiceVal") CourseServiceVal courseServiceVal) {
        this.courseRepos = courseRepos;
        this.courseServiceVal = courseServiceVal;
    }
    
    // Create
    @Override
    public Object create(CourseCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, CourseReadReq request) {
        CourseRes response = new CourseRes();
        response.setCourseName(request.getCourseName());
        response.setDescription(request.getDescription());
        response.setTeacherName(request.getTeacherName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(int courseID, CourseUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));
        
        return request;
    }

    // Delete
    @Override
    public Object delete(int courseID) {
        return courseID;
    }
}
