package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.ChapterCreateReq;
import be_project1.pet_project.dto.request.ChapterReadReq;
import be_project1.pet_project.dto.request.ChapterUpdateReq;

public interface ChapterService {
    // Create
    public Object create(ChapterCreateReq request);

    // Read
    public Object read(String sort, int page, int size, ChapterReadReq request);

     // Update
    public Object update(String chapterID, ChapterUpdateReq request);

    // Delete
    public Object delete(String chapterID);
}
