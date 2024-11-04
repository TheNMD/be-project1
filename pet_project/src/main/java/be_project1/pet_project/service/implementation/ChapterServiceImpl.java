package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.entity.ChapterEntity;
import be_project1.pet_project.entity.CourseEntity;
import be_project1.pet_project.repository.ChapterRepos;
import be_project1.pet_project.repository.CourseRepos;
import be_project1.pet_project.service.validation.ChapterServiceVal;
import be_project1.pet_project.dto.request.ChapterCreateReq;
import be_project1.pet_project.dto.request.ChapterReadReq;
import be_project1.pet_project.dto.request.ChapterUpdateReq;
import be_project1.pet_project.dto.response.ChapterRes;

@Service("chapterServiceImpl")
public class ChapterServiceImpl implements ChapterService {
    // Init
    private final ChapterRepos chapterRepos;
    private final CourseRepos courseRepos;
    private final ChapterServiceVal chapterServiceVal;

    @Autowired
    public ChapterServiceImpl(
        @Qualifier("chapterRepos") ChapterRepos chapterRepos,
        @Qualifier("courseRepos") CourseRepos courseRepos,
        @Qualifier("chapterServiceVal") ChapterServiceVal chapterServiceVal) {
        this.chapterRepos = chapterRepos;
        this.courseRepos = courseRepos;
        this.chapterServiceVal = chapterServiceVal;
    }
    
    // Create
    @Override
    public Object create(ChapterCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        int courseId = request.getCourseId() != 0 ? request.getCourseId() : -1;
        CourseEntity course = courseRepos.findById(courseId).orElseThrow(() -> new RuntimeException(String.format("Course not found [%d]", courseId)));

        ChapterEntity newChapter = new ChapterEntity();
        newChapter.setName(request.getName());
        newChapter.setDescription(request.getDescription());
        newChapter.setStatus(request.getStatus());
        newChapter.setCreatedDate(request.getCreatedDate());
        newChapter.setCourseObj(course);
        chapterRepos.save(newChapter);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, ChapterReadReq request) {
        ChapterRes response = new ChapterRes();
        response.setChapterName(request.getName());
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
    public Object update(int id, ChapterUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));
        
        int courseId = request.getCourseId() != 0 ? request.getCourseId() : -1;
        CourseEntity course = (courseId != -1) ? courseRepos.findById(courseId).orElseThrow(() -> new RuntimeException(String.format("Course not found [%d]",courseId))) : null;

        ChapterEntity existingChapter = chapterRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("Chapter not found [%d]", id)));
        existingChapter.setName(request.getName() != null ? request.getName() : existingChapter.getName());
        existingChapter.setDescription(request.getDescription() != null ? request.getDescription() : existingChapter.getDescription());
        existingChapter.setStatus(request.getStatus() != null ? request.getStatus() : existingChapter.getStatus());
        existingChapter.setCreatedDate(request.getCreatedDate() != null ? request.getCreatedDate() : existingChapter.getCreatedDate());
        existingChapter.setUpdatedDate(request.getUpdatedDate() != null ? request.getUpdatedDate() : existingChapter.getUpdatedDate());
        existingChapter.setCourseObj(course != null ? course : existingChapter.getCourseObj());
        chapterRepos.save(existingChapter);

        return request;
    }

    // Delete
    @Override
    public Object delete(int id) {
        ChapterEntity existingChapter = chapterRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("Chapter not found [%d]", id)));
        existingChapter.setStatus("inactive");
        chapterRepos.save(existingChapter);

        return existingChapter;
    }
}
