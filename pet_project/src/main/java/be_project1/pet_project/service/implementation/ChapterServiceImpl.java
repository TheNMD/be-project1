package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.service.validator.ChapterServiceVal;
import be_project1.pet_project.dto.request.ChapterReq;
import be_project1.pet_project.dto.response.ChapterRes;

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
    public Object create(ChapterReq request) {
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
    public Object read(String sort, int page, int size, ChapterReq request) {
        String error = chapterServiceVal.read(request);
        if (error != null) {
            return error;
        }
        
        ChapterRes response = new ChapterRes();
        response.setChapterName(request.getChapterName());
        response.setCourseName(request.getCourseName());
        response.setDescription(request.getDescription());
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
    public Object update(String chapterID, ChapterReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);
        
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
