package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.LessonService;
import be_project1.pet_project.entity.LessonEntity;
import be_project1.pet_project.repository.LessonRepos;
import be_project1.pet_project.service.validation.LessonServiceVal;
import be_project1.pet_project.dto.request.LessonCreateReq;
import be_project1.pet_project.dto.request.LessonReadReq;
import be_project1.pet_project.dto.request.LessonUpdateReq;
import be_project1.pet_project.dto.response.LessonRes;

@Service("lessonServiceImpl")
public class LessonServiceImpl implements LessonService {
    // Init
    private final LessonRepos lessonRepos;
    private final LessonServiceVal lessonServiceVal;

    @Autowired
    public LessonServiceImpl(
        @Qualifier("lessonRepos") LessonRepos lessonRepos,
        @Qualifier("lessonServiceVal") LessonServiceVal lessonServiceVal) {
        this.lessonRepos = lessonRepos;
        this.lessonServiceVal = lessonServiceVal;
    }

    // Create
    @Override
    public Object create(LessonCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, LessonReadReq request) {
        LessonRes response = new LessonRes();
        response.setLessonName(request.getLessonName());
        response.setType(request.getType());
        response.setUrl(request.getUrl());
        response.setLessonOrder(request.getLessonOrder());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(String lessonID, LessonUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));
        
        return request;
    }

    // Delete
    @Override
    public Object delete(String lessonID) {
        return lessonID;
    }
}
