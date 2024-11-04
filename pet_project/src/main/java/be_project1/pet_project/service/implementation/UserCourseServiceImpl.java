package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.UserCourseService;
import be_project1.pet_project.entity.UserCourseEntity;
import be_project1.pet_project.entity.UserEntity;
import be_project1.pet_project.entity.CourseEntity;
import be_project1.pet_project.repository.UserCourseRepos;
import be_project1.pet_project.repository.UserRepos;
import be_project1.pet_project.repository.CourseRepos;
import be_project1.pet_project.entity.key.UserCourseKey;
import be_project1.pet_project.service.validation.UserCourseServiceVal;
import be_project1.pet_project.dto.request.UserCourseCreateReq;
import be_project1.pet_project.dto.request.UserCourseReadReq;
import be_project1.pet_project.dto.request.UserCourseUpdateReq;
import be_project1.pet_project.dto.response.UserCourseRes;

@Service("userCourseServiceImpl")
public class UserCourseServiceImpl implements UserCourseService {
    // Init
    private final UserCourseRepos userCourseRepos;
    private final UserRepos userRepos;
    private final CourseRepos courseRepos;
    private final UserCourseServiceVal userCourseServiceVal;

    @Autowired
    public UserCourseServiceImpl(
        @Qualifier("userCourseRepos") UserCourseRepos userCourseRepos,
        @Qualifier("userRepos") UserRepos userRepos,
        @Qualifier("courseRepos") CourseRepos courseRepos,
        @Qualifier("userCourseServiceVal") UserCourseServiceVal userCourseServiceVal) {
        this.userCourseRepos = userCourseRepos;
        this.userRepos = userRepos;
        this.courseRepos = courseRepos;
        this.userCourseServiceVal = userCourseServiceVal;
    }
    
    // Create
    @Override
    public Object create(int userId, UserCourseCreateReq request) {
        request.setStatus("stopped");
        request.setCreatedDate(Date.from(Instant.now()));

        int ucUserId = request.getUserId() != 0 ? request.getUserId() : -1;
        UserEntity user = userRepos.findById(ucUserId).orElseThrow(() -> new RuntimeException(String.format("User not found [%d]", ucUserId)));
        
        int ucCourseId = request.getCourseId() != 0 ? request.getCourseId() : -1;
        CourseEntity course = courseRepos.findById(ucCourseId).orElseThrow(() -> new RuntimeException(String.format("Course not found [%d]", ucCourseId)));

        UserCourseEntity newUserCourse = new UserCourseEntity();
        newUserCourse.setRating(request.getRating());
        newUserCourse.setReview(request.getReview());
        newUserCourse.setStatus(request.getStatus());
        newUserCourse.setCreatedDate(request.getCreatedDate());
        newUserCourse.setUserObj(user);
        newUserCourse.setCourseObj(course);
        userCourseRepos.save(newUserCourse);

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

        int ucUserId = request.getUserId() != 0 ? request.getUserId() : -1;
        UserEntity user = (ucUserId != -1) ? userRepos.findById(ucUserId).orElseThrow(() -> new RuntimeException(String.format("User not found [%d]", ucUserId))) : null;

        int ucCourseId = request.getCourseId() != 0 ? request.getCourseId() : -1;
        CourseEntity course = (ucCourseId != -1) ? courseRepos.findById(ucCourseId).orElseThrow(() -> new RuntimeException(String.format("Course not found [%d]", ucCourseId))) : null;

        UserCourseKey id = new UserCourseKey(userId, courseId);
        UserCourseEntity existingUserCourse = userCourseRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("UserCourse not found [%d, %d]", userId, courseId)));
        existingUserCourse.setRating(request.getRating() != null ? request.getRating() : existingUserCourse.getRating());
        existingUserCourse.setReview(request.getReview() != null ? request.getReview() : existingUserCourse.getReview());
        existingUserCourse.setStatus(request.getStatus() != null ? request.getStatus() : existingUserCourse.getStatus());
        existingUserCourse.setCreatedDate(request.getCreatedDate() != null ? request.getCreatedDate() : existingUserCourse.getCreatedDate());
        existingUserCourse.setUpdatedDate(request.getUpdatedDate() != null ? request.getUpdatedDate() : existingUserCourse.getUpdatedDate());
        existingUserCourse.setUserObj(user != null ? user : existingUserCourse.getUserObj());
        existingUserCourse.setCourseObj(course != null ? course : existingUserCourse.getCourseObj());
        userCourseRepos.save(existingUserCourse);

        return request;
    }

    // Delete
    @Override
    public Object delete(int userId, int courseId) {
        UserCourseKey id = new UserCourseKey(userId, courseId);
        UserCourseEntity existingUserCourse = userCourseRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("UserCourse not found [%d, %d]", userId, courseId)));
        existingUserCourse.setStatus("inactive");
        userCourseRepos.save(existingUserCourse);

        return existingUserCourse;
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
