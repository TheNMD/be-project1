package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.UserCourseCreateReq;
import be_project1.pet_project.dto.request.UserCourseReadReq;
import be_project1.pet_project.dto.request.UserCourseUpdateReq;
import be_project1.pet_project.dto.request.UserCourseRateReq;
import be_project1.pet_project.dto.request.UserCourseReviewReq;

public interface UserCourseService {
    // Create
    public Object create(UserCourseCreateReq request);

    // Read
    public Object read(String sort, int page, int size, UserCourseReadReq request);

     // Update
    public Object update(String courseID, UserCourseUpdateReq request);

    // Delete
    public Object delete(String courseID);

    // View
    public Object view(String courseID);

    // Join
    public Object join(String courseID);

    // Rate
    public Object rate(String courseID, UserCourseRateReq request);

    // Review
    public Object review(String courseID, UserCourseReviewReq request);
}
