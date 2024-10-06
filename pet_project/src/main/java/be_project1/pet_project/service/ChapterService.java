package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.ChapterReq;

public interface ChapterService {
    // Create
    public Object create(ChapterReq request);

    // Read
    public Object read(String sort, int page, int size, ChapterReq request);

     // Update
    public Object update(String chapterID, ChapterReq request);

    // Delete
    public Object delete(String chapterID);
}
