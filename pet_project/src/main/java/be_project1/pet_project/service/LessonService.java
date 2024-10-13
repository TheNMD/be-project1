package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.LessonReq;

public interface LessonService {
    // Create
    public Object create(LessonReq request);

    // Read
    public Object read(String sort, int page, int size, LessonReq request);

     // Update
    public Object update(String lessonID, LessonReq request);

    // Delete
    public Object delete(String lessonID);
}
