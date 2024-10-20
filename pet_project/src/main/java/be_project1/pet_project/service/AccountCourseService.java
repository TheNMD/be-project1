package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.AccountCourseCreateReq;
import be_project1.pet_project.dto.request.AccountCourseReadReq;
import be_project1.pet_project.dto.request.AccountCourseUpdateReq;
import be_project1.pet_project.dto.request.AccountCourseRateReq;
import be_project1.pet_project.dto.request.AccountCourseReviewReq;

public interface AccountCourseService {
    // Create
    public Object create(AccountCourseCreateReq request);

    // Read
    public Object read(String sort, int page, int size, AccountCourseReadReq request);

     // Update
    public Object update(String courseID, AccountCourseUpdateReq request);

    // Delete
    public Object delete(String courseID);

    // View
    public Object view(String courseID);

    // Join
    public Object join(String courseID);

    // Rate
    public Object rate(String courseID, AccountCourseRateReq request);

    // Review
    public Object review(String courseID, AccountCourseReviewReq request);
}
