package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.dto.request.ChapterCreateReq;
import be_project1.pet_project.dto.request.ChapterReadReq;
import be_project1.pet_project.dto.request.ChapterUpdateReq;
import be_project1.pet_project.dto.response.ChapterRes;

@Service("chapterServiceImpl")
public class ChapterServiceImpl implements ChapterService {
    // Create
    @Override
    public Object create(ChapterCreateReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, ChapterReadReq request) {
        ChapterRes response = new ChapterRes();
        response.setChapterName(request.getChapterName());
        response.setDescription(request.getDescription());
        response.setChapterOrder(request.getChapterOrder());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
        
        return response;
    }

     // Update
    @Override
    public Object update(String chapterID, ChapterUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);
        
        return request;
    }

    // Delete
    @Override
    public Object delete(String chapterID) {
        return chapterID;
    }
}
