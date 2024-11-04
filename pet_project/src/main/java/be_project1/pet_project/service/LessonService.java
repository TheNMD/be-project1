package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.LessonCreateReq;
import be_project1.pet_project.dto.request.LessonReadReq;
import be_project1.pet_project.dto.request.LessonUpdateReq;

public interface LessonService {
    // Create
    public Object create(LessonCreateReq request);

    // Read
    public Object read(String sort, int page, int size, LessonReadReq request);

     // Update
    public Object update(int lessonId, LessonUpdateReq request);

    // Delete
    public Object delete(int lessonId);
}
