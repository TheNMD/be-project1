package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.entity.ChapterEntity;
import be_project1.pet_project.repository.ChapterRepos;
import be_project1.pet_project.service.validation.ChapterServiceVal;
import be_project1.pet_project.dto.request.ChapterCreateReq;
import be_project1.pet_project.dto.request.ChapterReadReq;
import be_project1.pet_project.dto.request.ChapterUpdateReq;
import be_project1.pet_project.dto.response.ChapterRes;

@Service("chapterServiceImpl")
public class ChapterServiceImpl implements ChapterService {
    // Init
    private final ChapterRepos chapterRepos;
    private final ChapterServiceVal chapterServiceVal;

    @Autowired
    public ChapterServiceImpl(
        @Qualifier("chapterRepos") ChapterRepos chapterRepos,
        @Qualifier("chapterServiceVal") ChapterServiceVal chapterServiceVal) {
        this.chapterRepos = chapterRepos;
        this.chapterServiceVal = chapterServiceVal;
    }
    
    // Create
    @Override
    public Object create(ChapterCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

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
        request.setUpdatedDate(Date.from(Instant.now()));
        
        return request;
    }

    // Delete
    @Override
    public Object delete(String chapterID) {
        return chapterID;
    }
}
