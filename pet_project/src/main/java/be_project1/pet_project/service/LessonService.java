package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.LessonManageReq;

public interface LessonService {
    // Create
    public Object create(LessonManageReq request);

    // Read
    public Object read(String sort, int page, int size, LessonManageReq request);

     // Update
    public Object update(String lessonID, LessonManageReq request);

    // Delete
    public Object delete(String lessonID);

    // Begin
    public Object begin(String lessonID);

    // Stop
    public Object stop(String lessonID);

    // Finish
    public Object finish(String lessonID);
}
