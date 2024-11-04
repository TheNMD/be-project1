package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.UserCourseCreateReq;
import be_project1.pet_project.dto.request.UserCourseReadReq;
import be_project1.pet_project.dto.request.UserCourseUpdateReq;

public interface UserCourseService {
    // Create
    public Object create(int userID, UserCourseCreateReq request);

    // Read
    public Object read(int userID, String sort, int page, int size, UserCourseReadReq request);

     // Update
    public Object update(int userID, int courseID, UserCourseUpdateReq request);

    // Delete
    public Object delete(int userID, int courseID);

    // // View
    // public Object view(String courseID);

    // // Join
    // public Object join(String courseID);

    // // Rate
    // public Object rate(String courseID, UserCourseCreateReq request);

    // // Review
    // public Object review(String courseID, UserCourseCreateReq request);
}
