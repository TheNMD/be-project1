package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.UserCourseLessonCreateReq;
import be_project1.pet_project.dto.request.UserCourseLessonReadReq;
import be_project1.pet_project.dto.request.UserCourseLessonUpdateReq;

public interface UserCourseLessonService {
    // Create
    public Object create(int userId, int courseId, UserCourseLessonCreateReq request);

    // Read
    public Object read(int userId, int courseId, String sort, int page, int size, UserCourseLessonReadReq request);

     // Update
    public Object update(int userId, int courseId, int lessonId, UserCourseLessonUpdateReq request);

    // Delete
    public Object delete(int userId, int courseId, int lessonId);

    // // Start
    // public Object start(String lessonId);

    // // Stop
    // public Object stop(String lessonId);

    // // Finish
    // public Object finish(String lessonId);
}
