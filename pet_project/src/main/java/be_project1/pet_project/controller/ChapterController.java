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

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.dto.request.ChapterCreateReq;
import be_project1.pet_project.service.ChapterService;

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
    public Object createChapter(@RequestBody ChapterCreateReq request) {
        return chapterService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_CHAPTER)
    public Object readChapter(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody ChapterCreateReq request) {
        return chapterService.read(sort, page, size, request);
    }

    // Update
    @PutMapping(URLConst.UPDATE_CHAPTER)
    public Object updateChapter(@PathVariable("chapter_id") String chapterID,
                                @RequestBody ChapterCreateReq request) {
        return chapterService.update(chapterID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_CHAPTER)
    public Object deleteChapter(@PathVariable("chapter_id") String chapterID) {
        return chapterService.delete(chapterID);
    }
}
