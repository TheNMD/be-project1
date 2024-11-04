package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.UserCourseCreateReq;
import be_project1.pet_project.dto.request.UserCourseReadReq;
import be_project1.pet_project.dto.request.UserCourseUpdateReq;

public interface UserCourseService {
    // Create
    public Object create(int userId, UserCourseCreateReq request);

    // Read
    public Object read(int userId, String sort, int page, int size, UserCourseReadReq request);

     // Update
    public Object update(int userId, int courseId, UserCourseUpdateReq request);

    // Delete
    public Object delete(int userId, int courseId);

    // // View
    // public Object view(String courseId);

    // // Join
    // public Object join(String courseId);

    // // Rate
    // public Object rate(String courseId, UserCourseCreateReq request);

    // // Review
    // public Object review(String courseId, UserCourseCreateReq request);
}
