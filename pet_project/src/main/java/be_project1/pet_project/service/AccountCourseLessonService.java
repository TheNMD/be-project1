package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.AccountCourseLessonCreateReq;
import be_project1.pet_project.dto.request.AccountCourseLessonReadReq;
import be_project1.pet_project.dto.request.AccountCourseLessonUpdateReq;

public interface AccountCourseLessonService {
    // Create
    public Object create(AccountCourseLessonCreateReq request);

    // Read
    public Object read(String sort, int page, int size, AccountCourseLessonReadReq request);

     // Update
    public Object update(String lessonID, AccountCourseLessonUpdateReq request);

    // Delete
    public Object delete(String lessonID);

    // Start
    public Object start(String lessonID);

    // Stop
    public Object stop(String lessonID);

    // Finish
    public Object finish(String lessonID);
}
