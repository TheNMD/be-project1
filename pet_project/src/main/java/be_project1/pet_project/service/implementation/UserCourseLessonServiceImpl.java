package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Service;
import be_project1.pet_project.service.UserCourseLessonService;
import be_project1.pet_project.dto.request.UserCourseLessonCreateReq;
import be_project1.pet_project.dto.request.UserCourseLessonReadReq;
import be_project1.pet_project.dto.request.UserCourseLessonUpdateReq;
import be_project1.pet_project.dto.response.UserCourseLessonRes;

@Service("userCourseLessonServiceImpl")
public class UserCourseLessonServiceImpl implements UserCourseLessonService {
    // Create
    @Override
    public Object create(UserCourseLessonCreateReq request) {
        request.setStatus("stopped");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, UserCourseLessonReadReq request) {
        UserCourseLessonRes response = new UserCourseLessonRes();
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(String lessonID, UserCourseLessonUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        return request;
    }

    // Delete
    @Override
    public Object delete(String lessonID) {
        return lessonID;
    }

    // Start
    @Override
    public Object start(String lessonID) {
        return lessonID;
    }

    // Stop
    @Override
    public Object stop(String lessonID) {
        return lessonID;
    }

    // Finish
    @Override
    public Object finish(String lessonID) {
        return lessonID;
    }
}
