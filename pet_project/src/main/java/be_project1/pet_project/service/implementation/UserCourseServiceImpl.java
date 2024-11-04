package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.UserCourseService;
import be_project1.pet_project.dto.request.UserCourseCreateReq;
import be_project1.pet_project.dto.request.UserCourseReadReq;
import be_project1.pet_project.dto.request.UserCourseUpdateReq;
import be_project1.pet_project.dto.request.UserCourseRateReq;
import be_project1.pet_project.dto.request.UserCourseReviewReq;
import be_project1.pet_project.dto.response.UserCourseRes;

@Service("userCourseServiceImpl")
public class UserCourseServiceImpl implements UserCourseService {
    // Create
    @Override
    public Object create(UserCourseCreateReq request) {
        request.setStatus("stopped");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, UserCourseReadReq request) {
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
    public Object update(String courseID, UserCourseUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    // Delete
    @Override
    public Object delete(String courseID) {
        return courseID;
    }

    // View
    @Override
    public Object view(String courseID) {
        return courseID;
    }

    // Join
    @Override
    public Object join(String courseID) {
        return courseID;
    }

    // Rate
    @Override
    public Object rate(String courseID, UserCourseRateReq request) {
        return request;
    }

    // Review
    @Override
    public Object review(String courseID, UserCourseReviewReq request) {
        return request;
    }
}
