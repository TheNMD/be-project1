package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.CourseReq;

public interface CourseService {
    // Create
    public Object create(CourseReq request);

    // Read
    public Object read(String sort, int page, int size, CourseReq request);

     // Update
    public Object update(String courseID, CourseReq request);

    // Delete
    public Object delete(String courseID);
}
