package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.LessonService;
import be_project1.pet_project.service.validator.LessonServiceVal;
import be_project1.pet_project.dto.request.LessonReq;
import be_project1.pet_project.dto.response.LessonRes;

@Service("lessonServiceImpl")
public class LessonServiceImpl implements LessonService {
    // Init
    private final LessonServiceVal lessonServiceVal;

    @Autowired
    public LessonServiceImpl(@Qualifier("lessonServiceVal") LessonServiceVal lessonServiceVal) {
        this.lessonServiceVal = lessonServiceVal;
    }

    // Create
    @Override
    public Object create(LessonReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);
        
        String error = lessonServiceVal.create(request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, LessonReq request) {
        String error = lessonServiceVal.read(request);
        if (error != null) {
            return error;
        }
        
        LessonRes response = new LessonRes();
        response.setLessonName(request.getLessonName());
        response.setChapterName(request.getChapterName());
        response.setCourseName(request.getCourseName());
        response.setType(request.getType());
        response.setUrl(request.getUrl());
        response.setOrder(request.getOrder());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(String lessonID, LessonReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);
        
        String error = lessonServiceVal.update(lessonID, request);
        if (error != null) {
            return error;
        }
        
        return request;
    }

    // Delete
    @Override
    public Object delete(String lessonID) {
        String error = lessonServiceVal.delete(lessonID);
        if (error != null) {
            return error;
        }
        
        return lessonID;
    }
}
