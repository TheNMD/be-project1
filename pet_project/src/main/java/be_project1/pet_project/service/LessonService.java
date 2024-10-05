package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.LessonManageReq;

public interface LessonService {
    // Create
    public Object create(LessonManageReq request);

    // Delete
    public Object delete(String lessonID);

     // Update
    public Object update(String lessonID, LessonManageReq request);

    // Search
    public Object search(String sort, int page, int size, LessonManageReq request);

    // Search
    public Object begin(String lessonID);

    // Search
    public Object stop(String lessonID);

    // Search
    public Object finish(String lessonID);
}
