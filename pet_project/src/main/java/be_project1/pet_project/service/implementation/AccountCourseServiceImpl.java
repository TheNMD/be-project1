package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.AccountCourseService;
import be_project1.pet_project.service.validator.AccountCourseServiceVal;
import be_project1.pet_project.dto.request.AccountCourseReq;
import be_project1.pet_project.dto.response.AccountCourseRes;

@Service("accountCourseServiceImpl")
public class AccountCourseServiceImpl implements AccountCourseService {
    // Init
    private final AccountCourseServiceVal accountCourseServiceVal;

    @Autowired
    public AccountCourseServiceImpl(@Qualifier("accountCourseServiceVal") AccountCourseServiceVal accountCourseServiceVal) {
        this.accountCourseServiceVal = accountCourseServiceVal;
    }

    // Create
    @Override
    public Object create(AccountCourseReq request) {
        request.setStatus("stopped");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        String error = accountCourseServiceVal.create(request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, AccountCourseReq request) {
        String error = accountCourseServiceVal.read(request);
        if (error != null) {
            return error;
        }

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
    public Object update(String courseID, AccountCourseReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);
        
        String error = accountCourseServiceVal.update(courseID, request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Delete
    @Override
    public Object delete(String courseID) {
        String error = accountCourseServiceVal.delete(courseID);
        if (error != null) {
            return error;
        }

        return courseID;
    }

    // View
    @Override
    public Object view(String courseID) {
        String error = accountCourseServiceVal.view(courseID);
        if (error != null) {
            return error;
        }
        
        return courseID;
    }

    // Join
    @Override
    public Object join(String courseID) {
        String error = accountCourseServiceVal.join(courseID);
        if (error != null) {
            return error;
        }
        
        return courseID;
    }

    // Rate
    @Override
    public Object rate(String courseID, AccountCourseReq request) {
        String error = accountCourseServiceVal.rate(courseID, request);
        if (error != null) {
            return error;
        }
        
        return request;
    }

    // Rate
    @Override
    public Object review(String courseID, AccountCourseReq request) {
        String error = accountCourseServiceVal.review(courseID, request);
        if (error != null) {
            return error;
        }
        
        return request;
    }
}
