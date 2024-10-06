package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.service.validator.ChapterServiceVal;
import be_project1.pet_project.dto.request.ChapterManageReq;
import be_project1.pet_project.dto.response.ChapterManageRes;

@Service("chapterServiceImpl")
public class ChapterServiceImpl implements ChapterService {
    // Init
    private final ChapterServiceVal chapterServiceVal;

    @Autowired
    public ChapterServiceImpl(@Qualifier("chapterServiceVal") ChapterServiceVal chapterServiceVal) {
        this.chapterServiceVal = chapterServiceVal;
    }

    // Create
    @Override
    public Object create(ChapterManageReq request) {
        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, ChapterManageReq request) {
        ChapterManageRes response = new ChapterManageRes();

        // response.setChapterName(request.getChapterName());
        // response.setDescription(request.getDescription());
        // response.setTeacherName(request.getTeacherName());
        // response.setStatus(request.getStatus());
        // response.setRating(request.getRating());
        // response.setCreatedDate(request.getCreatedDate());
        // response.setSort(sort);
        // response.setPage(page);
        // response.setSize(size);
        
        return response;
    }

     // Update
    @Override
    public Object update(String chapterID, ChapterManageReq request) {
        return request;
    }

    // Delete
    @Override
    public Object delete(String userID) {
        return userID;
    }
}
