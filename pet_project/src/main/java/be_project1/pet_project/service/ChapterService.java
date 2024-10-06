package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.ChapterManageReq;

public interface ChapterService {
    // Create
    public Object create(ChapterManageReq request);

    // Read
    public Object read(String sort, int page, int size, ChapterManageReq request);

     // Update
    public Object update(String chapterID, ChapterManageReq request);

    // Delete
    public Object delete(String chapterID);
}
