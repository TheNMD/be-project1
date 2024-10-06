package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.AccountCourseReq;

public interface AccountCourseService {
    // Create
    public Object create(AccountCourseReq request);

    // Read
    public Object read(String sort, int page, int size, AccountCourseReq request);

     // Update
    public Object update(String courseID, AccountCourseReq request);

    // Delete
    public Object delete(String courseID);

    // View
    public Object view(String courseID);

    // Join
    public Object join(String courseID);

    // Rate
    public Object rate(String courseID, AccountCourseReq request);

    // Review
    public Object review(String courseID, AccountCourseReq request);
}
