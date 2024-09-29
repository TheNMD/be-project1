package be_project1.lesson_15.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_15.constant.URLConstant;
import be_project1.lesson_15.dto.request.ChapterRequest;

@RestController
public class ChapterController {
    // Create chapter
    @PostMapping(URLConstant.CHAPTER_CREATE)
    public Object createChapter(@RequestBody ChapterRequest request) {
        return request;
    }

    // Delete chapter
    @DeleteMapping(URLConstant.CHAPTER_DELETE)
    public Object deleteChapter(@PathVariable("chapter_id") String chapterID) { 
        return "Chapter " + chapterID + " deleted!";
    }

     // Update chapter
    @PutMapping(URLConstant.CHAPTER_UPDATE)
    public Object updateChapter(@PathVariable("chapter_id") String chapterID,  @RequestBody ChapterRequest request) { 
        return request;
    }
}
