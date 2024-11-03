package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.UserCourseLessonCreateReq;
import be_project1.pet_project.dto.request.UserCourseLessonReadReq;
import be_project1.pet_project.dto.request.UserCourseLessonUpdateReq;

public interface UserCourseLessonService {
    // Create
    public Object create(UserCourseLessonCreateReq request);

    // Read
    public Object read(String sort, int page, int size, UserCourseLessonReadReq request);

     // Update
    public Object update(String lessonID, UserCourseLessonUpdateReq request);

    // Delete
    public Object delete(String lessonID);

    // Start
    public Object start(String lessonID);

    // Stop
    public Object stop(String lessonID);

    // Finish
    public Object finish(String lessonID);
}
