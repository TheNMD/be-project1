package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.AccountCourseLessonReq;

public interface AccountCourseLessonService {
    // Create
    public Object create(AccountCourseLessonReq request);

    // Read
    public Object read(String sort, int page, int size, AccountCourseLessonReq request);

     // Update
    public Object update(String lessonID, AccountCourseLessonReq request);

    // Delete
    public Object delete(String lessonID);

    // Start
    public Object start(String lessonID);

    // Stop
    public Object stop(String lessonID);

    // Finish
    public Object finish(String lessonID);
}
