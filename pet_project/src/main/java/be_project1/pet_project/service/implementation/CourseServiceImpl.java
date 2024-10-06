package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.CourseService;
import be_project1.pet_project.service.validator.CourseServiceVal;
import be_project1.pet_project.dto.request.CourseReq;
import be_project1.pet_project.dto.response.CourseRes;

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
    public Object create(CourseReq request) {
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
    public Object read(String sort, int page, int size, CourseReq request) {
        String error = courseServiceVal.read(request);
        if (error != null) {
            return error;
        }
        
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
    public Object update(String courseID, CourseReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);
        
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
}
