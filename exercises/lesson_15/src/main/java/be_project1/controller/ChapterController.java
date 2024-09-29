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
}
