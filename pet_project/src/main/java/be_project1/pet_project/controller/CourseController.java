// package be_project1.pet_project.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import be_project1.pet_project.constant.URLConst;
// import be_project1.pet_project.dto.request.CourseManageReq;
// import be_project1.pet_project.dto.request.CourseSearchReq;
// import be_project1.pet_project.dto.response.CourseSearchRes;

// @RestController
// public class CourseController {
//     // Create course
//     @PostMapping(URLConst.COURSE_CREATE)
//     public Object createCourse(@RequestBody CourseManageReq request) {
//         return request;
//     }

//     // Delete course
//     @DeleteMapping(URLConst.COURSE_DELETE)
//     public Object deleteCourse(@PathVariable("course_id") String courseID) { 
//         return "Course " + courseID + " deleted!";
//     }

//      // Update course
//     @PutMapping(URLConst.COURSE_UPDATE)
//     public Object updateCourse(@PathVariable("course_id") String courseID,  @RequestBody CourseManageReq request) { 
//         return request;
//     }

//     // Search course
//     @PostMapping(URLConst.COURSE_SEARCH)
//     public Object searchCourse(@RequestParam("sort") String sort,
//                                @RequestParam("page") int page,
//                                @RequestParam("size") int size,
//                                @RequestBody CourseSearchReq request) {

//         CourseSearchRes response = new CourseSearchRes();

//         response.setCourseName(request.getCourseName());
//         response.setTeacherName(request.getTeacherName());
//         response.setStatus(request.getStatus());
//         response.setRating(request.getRating());
//         response.setCreatedDate(request.getCreatedDate());
//         response.setSort(sort);
//         response.setPage(page);
//         response.setSize(size);
            
//         return response;
//     }

//     // View a course
//     @GetMapping(URLConst.COURSE_VIEW)
//     public Object viewCourse(@PathVariable("course_id") String courseID) {
//         return courseID;
//     }

//     // Join a course
//     @PostMapping(URLConst.JOIN_COURSE)
//     public Object joinCourse(@PathVariable("course_id") String courseID) {
//         return "Joined course " + courseID + "!";
//     }

//     // Rate a course
//     @PostMapping(URLConst.RATE_COURSE)
//     public Object rateCourse(@PathVariable("course_id") String courseID, @RequestBody CourseManageReq request) {
//         return request;
//     }
// }
