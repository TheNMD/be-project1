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
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);
        
        String error = chapterServiceVal.create(request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, ChapterManageReq request) {
        String error = chapterServiceVal.read(request);
        if (error != null) {
            return error;
        }
        
        ChapterManageRes response = new ChapterManageRes();
        response.setChapterName(request.getChapterName());
        response.setDescription(request.getDescription());
        response.setCourseName(request.getCourseName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
        
        return response;
    }

     // Update
    @Override
    public Object update(String chapterID, ChapterManageReq request) {
        String error = chapterServiceVal.update(chapterID, request);
        if (error != null) {
            return error;
        }
        
        return request;
    }

    // Delete
    @Override
    public Object delete(String chapterID) {
        String error = chapterServiceVal.delete(chapterID);
        if (error != null) {
            return error;
        }
        
        return chapterID;
    }
}
