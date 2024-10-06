package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.AccountCourseLessonService;
import be_project1.pet_project.service.validator.AccountCourseLessonServiceVal;
import be_project1.pet_project.dto.request.AccountCourseLessonReq;
import be_project1.pet_project.dto.response.AccountCourseLessonRes;

@Service("accountCourseLessonServiceImpl")
public class AccountCourseLessonServiceImpl implements AccountCourseLessonService {
    // Init
    private final AccountCourseLessonServiceVal accountCourseLessonServiceVal;

    @Autowired
    public AccountCourseLessonServiceImpl(@Qualifier("accountCourseLessonServiceVal") AccountCourseLessonServiceVal accountCourseLessonServiceVal) {
        this.accountCourseLessonServiceVal = accountCourseLessonServiceVal;
    }

    // Create
    @Override
    public Object create(AccountCourseLessonReq request) {
        request.setStatus("stopped");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        String error = accountCourseLessonServiceVal.create(request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, AccountCourseLessonReq request) {
        String error = accountCourseLessonServiceVal.read(request);
        if (error != null) {
            return error;
        }

        AccountCourseLessonRes response = new AccountCourseLessonRes();
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(String lessonID, AccountCourseLessonReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);
        
        String error = accountCourseLessonServiceVal.update(lessonID, request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Delete
    @Override
    public Object delete(String lessonID) {
        String error = accountCourseLessonServiceVal.delete(lessonID);
        if (error != null) {
            return error;
        }

        return lessonID;
    }

    // Start
    @Override
    public Object start(String lessonID) {
        String error = accountCourseLessonServiceVal.delete(lessonID);
        if (error != null) {
            return error;
        }
        
        return lessonID;
    }

    // Stop
    @Override
    public Object stop(String lessonID) {
        String error = accountCourseLessonServiceVal.delete(lessonID);
        if (error != null) {
            return error;
        }
        
        return lessonID;
    }

    // Finish
    @Override
    public Object finish(String lessonID) {
        String error = accountCourseLessonServiceVal.delete(lessonID);
        if (error != null) {
            return error;
        }
        
        return lessonID;
    }
}
