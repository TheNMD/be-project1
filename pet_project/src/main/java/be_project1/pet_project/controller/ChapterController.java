package be_project1.pet_project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.dto.request.ChapterCreateReq;
import be_project1.pet_project.dto.request.ChapterReadReq;
import be_project1.pet_project.dto.request.ChapterUpdateReq;

@RestController("chapterController")
@RequestMapping("/api/v1")
public class ChapterController {
    // Init
    private final ChapterService chapterService;

    @Autowired
    public ChapterController(@Qualifier("chapterServiceImpl") ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    // Create
    @PostMapping(URLConst.CREATE_CHAPTER)
    public ResponseEntity<?> createChapter(@Validated @RequestBody ChapterCreateReq request) {
        Object res = chapterService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @PostMapping(URLConst.READ_CHAPTER)
    public ResponseEntity<?> readChapter(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody ChapterReadReq request) {
        Object res = chapterService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_CHAPTER)
    public ResponseEntity<?> updateChapter(
        @Validated
        @PathVariable("chapter_id") int chapterID,
        @RequestBody ChapterUpdateReq request) {
        Object res = chapterService.update(chapterID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_CHAPTER)
    public ResponseEntity<?> deleteChapter(@Validated @PathVariable("chapter_id") int chapterID) {
        Object res = chapterService.delete(chapterID);
        return ResponseEntity.ok(res);
    }
}
