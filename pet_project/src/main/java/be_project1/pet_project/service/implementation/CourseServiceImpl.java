package be_project1.pet_project.service.implementation;

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
        return request;
    }

    // Delete
    @Override
    public Object delete(String userID) {
        return userID;
    }

     // Update
    @Override
    public Object update(String courseID, CourseManageReq request) {
        return request;
    }

    // Search
    @Override
    public Object search(String sort, int page, int size, CourseManageReq request) {
        CourseManageRes response = new CourseManageRes();

        response.setCourseName(request.getCourseName());
        response.setTeacherName(request.getTeacherName());
        response.setStatus(request.getStatus());
        response.setRating(request.getRating());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // View a course
    @Override
    public Object view(String courseID) {
        return courseID;
    }

    // Join a course
    @Override
    public Object join(String courseID) {
        return courseID;
    }

    // Rate a course
    @Override
    public Object rate(String courseID, CourseManageReq request) {
        return courseID;
    }
}
