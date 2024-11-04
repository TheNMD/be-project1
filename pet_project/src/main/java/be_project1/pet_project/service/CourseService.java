package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.CourseCreateReq;
import be_project1.pet_project.dto.request.CourseReadReq;
import be_project1.pet_project.dto.request.CourseUpdateReq;

public interface CourseService {
    // Create
    public Object create(CourseCreateReq request);

    // Read
    public Object read(String sort, int page, int size, CourseReadReq request);

     // Update
    public Object update(int courseId, CourseUpdateReq request);

    // Delete
    public Object delete(int courseId);
}
