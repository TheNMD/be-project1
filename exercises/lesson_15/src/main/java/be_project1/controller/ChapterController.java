package be_project1.lesson_15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_15.constant.URLConst;
import be_project1.lesson_15.dto.request.ChapterManageReq;
import exercises.lesson_15.src.main.java.be_project1.dto.request.ChapterSearchReq;
import exercises.lesson_15.src.main.java.be_project1.dto.request.CourseSearchReq;
import exercises.lesson_15.src.main.java.be_project1.dto.response.ChapterSearchRes;
import exercises.lesson_15.src.main.java.be_project1.dto.response.CourseSearchRes;

@RestController
public class ChapterController {
    // Create chapter
    @PostMapping(URLConst.CHAPTER_CREATE)
    public Object createChapter(@RequestBody ChapterManageReq request) {
        return request;
    }

    // Delete chapter
    @DeleteMapping(URLConst.CHAPTER_DELETE)
    public Object deleteChapter(@PathVariable("chapter_id") String chapterID) { 
        return "Chapter " + chapterID + " deleted!";
    }

     // Update chapter
    @PutMapping(URLConst.CHAPTER_UPDATE)
    public Object updateChapter(@PathVariable("chapter_id") String chapterID,  @RequestBody ChapterManageReq request) { 
        return request;
    }

    // Search chapter
    @PostMapping(URLConst.CHAPTER_SEARCH)
    public Object searchChapter(@RequestParam("sort") String sort,
                                @RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestBody ChapterSearchReq request) {

        ChapterSearchRes response = new ChapterSearchRes();
        
        response.setChapterName(request.getChapterName());
        response.setCourseName(request.getCourseName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }
}
