package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.LessonService;
import be_project1.pet_project.entity.LessonEntity;
import be_project1.pet_project.entity.ChapterEntity;
import be_project1.pet_project.repository.LessonRepos;
import be_project1.pet_project.repository.ChapterRepos;
import be_project1.pet_project.service.validation.LessonServiceVal;
import be_project1.pet_project.dto.request.LessonCreateReq;
import be_project1.pet_project.dto.request.LessonReadReq;
import be_project1.pet_project.dto.request.LessonUpdateReq;
import be_project1.pet_project.dto.response.LessonRes;

@Service("lessonServiceImpl")
public class LessonServiceImpl implements LessonService {
    // Init
    private final LessonRepos lessonRepos;
    private final ChapterRepos chapterRepos;
    private final LessonServiceVal lessonServiceVal;

    @Autowired
    public LessonServiceImpl(
        @Qualifier("lessonRepos") LessonRepos lessonRepos,
        @Qualifier("chapterRepos") ChapterRepos chapterRepos,
        @Qualifier("lessonServiceVal") LessonServiceVal lessonServiceVal) {
        this.lessonRepos = lessonRepos;
        this.chapterRepos = chapterRepos;
        this.lessonServiceVal = lessonServiceVal;
    }

    // Create
    @Override
    public Object create(LessonCreateReq request) {
        request.setStatus("active");
        request.setCreatedDate(Date.from(Instant.now()));

        int chapterId = request.getChapterId() != 0 ? request.getChapterId() : -1;
        ChapterEntity chapter = chapterRepos.findById(chapterId).orElseThrow(() -> new RuntimeException(String.format("Chapter not found [%d]", chapterId)));

        LessonEntity newLesson = new LessonEntity();
        newLesson.setName(request.getName());
        newLesson.setDescription(request.getDescription());
        newLesson.setStatus(request.getStatus());
        newLesson.setCreatedDate(request.getCreatedDate());
        newLesson.setChapterObj(chapter);
        lessonRepos.save(newLesson);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, LessonReadReq request) {
        LessonRes response = new LessonRes();
        response.setLessonName(request.getName());
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
    public Object update(int lessonId, LessonUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));
        
        int chapterId = request.getChapterId() != 0 ? request.getChapterId() : -1;
        ChapterEntity chapter = (chapterId != -1) ? chapterRepos.findById(chapterId).orElseThrow(() -> new RuntimeException(String.format("Chapter not found [%d]",chapterId))) : null;

        LessonEntity existingLesson = lessonRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("Lesson not found [%d]", id)));
        existingLesson.setName(request.getName() != null ? request.getName() : existingLesson.getName());
        existingLesson.setDescription(request.getDescription() != null ? request.getDescription() : existingLesson.getDescription());
        existingLesson.setStatus(request.getStatus() != null ? request.getStatus() : existingLesson.getStatus());
        existingLesson.setCreatedDate(request.getCreatedDate() != null ? request.getCreatedDate() : existingLesson.getCreatedDate());
        existingLesson.setUpdatedDate(request.getUpdatedDate() != null ? request.getUpdatedDate() : existingLesson.getUpdatedDate());
        existingLesson.setChapterObj(chapter != null ? chapter : existingLesson.getChapterObj());
        lessonRepos.save(existingLesson);

        return request;
    }

    // Delete
    @Override
    public Object delete(int id) {
        LessonEntity existingLesson = lessonRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("Lesson not found [%d]", id)));
        existingLesson.setStatus("inactive");
        lessonRepos.save(existingLesson);

        return existingLesson;
    }
}
