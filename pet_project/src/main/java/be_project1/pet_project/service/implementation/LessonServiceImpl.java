package be_project1.pet_project.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.LessonService;
import be_project1.pet_project.service.validator.LessonServiceVal;
import be_project1.pet_project.dto.request.LessonManageReq;
import be_project1.pet_project.dto.response.LessonManageRes;

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
    public Object create(LessonManageReq request) {
        return request;
    }

    // Delete
    @Override
    public Object delete(String userID) {
        return userID;
    }

     // Update
    @Override
    public Object update(String lessonID, LessonManageReq request) {
        return request;
    }

    // Search
    @Override
    public Object search(String sort, int page, int size, LessonManageReq request) {
        LessonManageRes response = new LessonManageRes();

        // response.setLessonName(request.getLessonName());
        // response.setTeacherName(request.getTeacherName());
        // response.setStatus(request.getStatus());
        // response.setRating(request.getRating());
        // response.setCreatedDate(request.getCreatedDate());
        // response.setSort(sort);
        // response.setPage(page);
        // response.setSize(size);
            
        return response;
    }

    // View
    @Override
    public Object begin(String lessonID) {
        return lessonID;
    }

    // Join
    @Override
    public Object stop(String lessonID) {
        return lessonID;
    }

    // Rate
    @Override
    public Object finish(String lessonID) {
        return lessonID;
    }
}
