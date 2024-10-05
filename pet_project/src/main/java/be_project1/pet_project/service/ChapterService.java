package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.ChapterManageReq;

public interface ChapterService {
    // Create
    public Object create(ChapterManageReq request);

    // Delete
    public Object delete(String chapterID);

     // Update
    public Object update(String chapterID, ChapterManageReq request);

    // Search
    public Object search(String sort, int page, int size, ChapterManageReq request);
}
