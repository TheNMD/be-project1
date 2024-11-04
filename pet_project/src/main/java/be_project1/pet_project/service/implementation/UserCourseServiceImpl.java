package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.UserCourseService;
import be_project1.pet_project.entity.UserCourseEntity;
import be_project1.pet_project.repository.UserCourseRepos;
import be_project1.pet_project.service.validation.UserCourseServiceVal;
import be_project1.pet_project.dto.request.UserCourseCreateReq;
import be_project1.pet_project.dto.request.UserCourseReadReq;
import be_project1.pet_project.dto.request.UserCourseUpdateReq;
import be_project1.pet_project.dto.response.UserCourseRes;

@Service("userCourseServiceImpl")
public class UserCourseServiceImpl implements UserCourseService {
    // Init
    private final UserCourseRepos userCourseRepos;
    private final UserCourseServiceVal userCourseServiceVal;

    @Autowired
    public UserCourseServiceImpl(
        @Qualifier("userCourseRepos") UserCourseRepos userCourseRepos,
        @Qualifier("userCourseServiceVal") UserCourseServiceVal userCourseServiceVal) {
        this.userCourseRepos = userCourseRepos;
        this.userCourseServiceVal = userCourseServiceVal;
    }
    
    // Create
    @Override
    public Object create(int userId, UserCourseCreateReq request) {
        request.setStatus("stopped");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(int userId, String sort, int page, int size, UserCourseReadReq request) {
        UserCourseRes response = new UserCourseRes();
        response.setRating(request.getRating());
        response.setReview(request.getReview());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(int userId, int courseId, UserCourseUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(int userId, int courseId) {
        return courseId;
    }

    // // View
    // @Override
    // public Object view(String courseId) {
    //     return courseId;
    // }

    // // Join
    // @Override
    // public Object join(String courseId) {
    //     return courseId;
    // }

    // // Rate
    // @Override
    // public Object rate(String courseId, UserCourseCreateReq request) {
    //     return request;
    // }

    // // Review
    // @Override
    // public Object review(String courseId, UserCourseCreateReq request) {
    //     return request;
    // }
}