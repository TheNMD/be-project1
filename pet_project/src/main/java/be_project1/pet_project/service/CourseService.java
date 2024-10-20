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
    public Object update(String courseID, CourseUpdateReq request);

    // Delete
    public Object delete(String courseID);
}
