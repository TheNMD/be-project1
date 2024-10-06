package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.CourseManageReq;

public interface CourseService {
    // Create
    public Object create(CourseManageReq request);

    // Read
    public Object read(String sort, int page, int size, CourseManageReq request);

     // Update
    public Object update(String courseID, CourseManageReq request);

    // Delete
    public Object delete(String courseID);

    // View
    public Object view(String courseID);

    // Join
    public Object join(String courseID);

    // Rate
    public Object rate(String courseID, CourseManageReq request);

    // Review
    public Object review(String courseID, CourseManageReq request);
}
