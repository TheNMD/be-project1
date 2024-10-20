package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import be_project1.pet_project.service.AccountCourseService;
import be_project1.pet_project.dto.request.AccountCourseCreateReq;
import be_project1.pet_project.dto.request.AccountCourseReadReq;
import be_project1.pet_project.dto.request.AccountCourseUpdateReq;
import be_project1.pet_project.dto.request.AccountCourseRateReq;
import be_project1.pet_project.dto.request.AccountCourseReviewReq;
import be_project1.pet_project.dto.response.AccountCourseRes;

@Service("accountCourseServiceImpl")
public class AccountCourseServiceImpl implements AccountCourseService {
    // Create
    @Override
    public Object create(AccountCourseCreateReq request) {
        request.setStatus("stopped");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, AccountCourseReadReq request) {
        AccountCourseRes response = new AccountCourseRes();
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
    public Object update(String courseID, AccountCourseUpdateReq request) {
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
    public Object rate(String courseID, AccountCourseRateReq request) {
        return request;
    }

    // Review
    @Override
    public Object review(String courseID, AccountCourseReviewReq request) {
        return request;
    }
}
