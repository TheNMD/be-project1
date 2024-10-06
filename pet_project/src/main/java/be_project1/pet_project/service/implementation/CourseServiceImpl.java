package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.CourseService;
import be_project1.pet_project.service.validator.CourseServiceVal;
import be_project1.pet_project.dto.request.CourseManageReq;
import be_project1.pet_project.dto.response.CourseManageRes;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
    // Init
    private final CourseServiceVal courseServiceVal;

    @Autowired
    public CourseServiceImpl(@Qualifier("courseServiceVal") CourseServiceVal courseServiceVal) {
        this.courseServiceVal = courseServiceVal;
    }

    // Create
    @Override
    public Object create(CourseManageReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        String error = courseServiceVal.create(request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, CourseManageReq request) {
        String error = courseServiceVal.read(request);
        if (error != null) {
            return error;
        }
        
        CourseManageRes response = new CourseManageRes();
        response.setCourseName(request.getCourseName());
        response.setDescription(request.getDescription());
        response.setTeacherName(request.getTeacherName());
        response.setStatus(request.getStatus());
        response.setRating(request.getRating());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(String courseID, CourseManageReq request) {
        String error = courseServiceVal.update(courseID, request);
        if (error != null) {
            return error;
        }
        
        return request;
    }

    // Delete
    @Override
    public Object delete(String courseID) {
        String error = courseServiceVal.delete(courseID);
        if (error != null) {
            return error;
        }

        return courseID;
    }

    // View
    @Override
    public Object view(String courseID) {
        String error = courseServiceVal.view(courseID);
        if (error != null) {
            return error;
        }
        
        return courseID;
    }

    // Join
    @Override
    public Object join(String courseID) {
        String error = courseServiceVal.join(courseID);
        if (error != null) {
            return error;
        }
        
        return courseID;
    }

    // Rate
    @Override
    public Object rate(String courseID, CourseManageReq request) {
        String error = courseServiceVal.rate(courseID, request);
        if (error != null) {
            return error;
        }
        
        return request;
    }

    // Rate
    @Override
    public Object review(String courseID, CourseManageReq request) {
        String error = courseServiceVal.review(courseID, request);
        if (error != null) {
            return error;
        }
        
        return request;
    }
}
