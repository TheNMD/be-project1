package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.CourseManageReq;

public interface CourseService {
    // Create
    public Object create(CourseManageReq request);

    // Delete
    public Object delete(String userID);

     // Update
    public Object update(String courseID, CourseManageReq request);

    // Search
    public Object search(String sort, int page, int size, CourseManageReq request);

    // View
    public Object view(String courseID);

    // Join
    public Object join(String courseID);

    // Rate
    public Object rate(String courseID, CourseManageReq request);
}
