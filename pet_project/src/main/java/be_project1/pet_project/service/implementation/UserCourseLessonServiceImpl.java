package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.UserCourseLessonService;
import be_project1.pet_project.entity.UserCourseLessonEntity;
import be_project1.pet_project.entity.UserCourseEntity;
import be_project1.pet_project.entity.LessonEntity;
import be_project1.pet_project.repository.UserCourseLessonRepos;
import be_project1.pet_project.repository.UserCourseRepos;
import be_project1.pet_project.repository.LessonRepos;
import be_project1.pet_project.entity.key.UserCourseKey;
import be_project1.pet_project.entity.key.UserCourseLessonKey;
import be_project1.pet_project.service.validation.UserCourseLessonServiceVal;
import be_project1.pet_project.dto.request.UserCourseLessonCreateReq;
import be_project1.pet_project.dto.request.UserCourseLessonReadReq;
import be_project1.pet_project.dto.request.UserCourseLessonUpdateReq;
import be_project1.pet_project.dto.response.UserCourseLessonRes;

@Service("userCourseLessonServiceImpl")
public class UserCourseLessonServiceImpl implements UserCourseLessonService {
    // Init
    private final UserCourseLessonRepos userCourseLessonRepos;
    private final UserCourseRepos userCourseRepos;
    private final LessonRepos lessonRepos;
    private final UserCourseLessonServiceVal userCourseLessonServiceVal;

    @Autowired
    public UserCourseLessonServiceImpl(
        @Qualifier("userCourseLessonRepos") UserCourseLessonRepos userCourseLessonRepos,
        @Qualifier("userCourseRepos") UserCourseRepos userCourseRepos,
        @Qualifier("lessonRepos") LessonRepos lessonRepos,
        @Qualifier("userCourseLessonServiceVal") UserCourseLessonServiceVal userCourseLessonServiceVal) {
        this.userCourseLessonRepos = userCourseLessonRepos;
        this.userCourseRepos = userCourseRepos;
        this.lessonRepos = lessonRepos;
        this.userCourseLessonServiceVal = userCourseLessonServiceVal;
    }
    
    // Create
    @Override
    public Object create(int userId, int courseId, UserCourseLessonCreateReq request) {
        request.setStatus("stopped");
        request.setCreatedDate(Date.from(Instant.now()));

        UserCourseKey id = new UserCourseKey(userId, courseId);
        UserCourseEntity userCourse = userCourseRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("UserCourse not found [%d, %d]", userId, courseId)));

        int lessonId = request.getLessonId() != 0 ? request.getLessonId() : -1;
        LessonEntity lesson = (lessonId != -1) ? lessonRepos.findById(lessonId).orElseThrow(() -> new RuntimeException(String.format("Lesson not found [%d]", lessonId))) : null;

        UserCourseLessonEntity newUserCourseLesson = new UserCourseLessonEntity();
        newUserCourseLesson.setStatus(request.getStatus());
        newUserCourseLesson.setCreatedDate(request.getCreatedDate());
        newUserCourseLesson.setUcUserId(userId);
        newUserCourseLesson.setUcCourseId(courseId);
        newUserCourseLesson.setUcObj(userCourse);
        newUserCourseLesson.setLessonId(lessonId);
        newUserCourseLesson.setLessonObj(lesson);
        userCourseLessonRepos.save(newUserCourseLesson);

        return request;
    }

    // Read
    @Override
    public Object read(int userId, int courseId, String sort, int page, int size, UserCourseLessonReadReq request) {
        UserCourseLessonRes response = new UserCourseLessonRes();
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(int userId, int courseId, int lessonId, UserCourseLessonUpdateReq request) {
        request.setUpdatedDate(Date.from(Instant.now()));

        UserCourseLessonKey id = new UserCourseLessonKey(userId, courseId, lessonId);
        UserCourseLessonEntity existingUserCourseLesson = userCourseLessonRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("UserCourseLesson not found [%d, %d, %d]", userId, courseId, lessonId)));
        existingUserCourseLesson.setStatus(request.getStatus() != null ? request.getStatus() : existingUserCourseLesson.getStatus());
        existingUserCourseLesson.setCreatedDate(request.getCreatedDate() != null ? request.getCreatedDate() : existingUserCourseLesson.getCreatedDate());
        existingUserCourseLesson.setUpdatedDate(request.getUpdatedDate() != null ? request.getUpdatedDate() : existingUserCourseLesson.getUpdatedDate());
        userCourseLessonRepos.save(existingUserCourseLesson);

        return existingUserCourseLesson;
    }

    // Delete
    @Override
    public Object delete(int userId, int courseId, int lessonId) {
        UserCourseLessonKey id = new UserCourseLessonKey(userId, courseId, lessonId);
        UserCourseLessonEntity existingUserCourseLesson = userCourseLessonRepos.findById(id).orElseThrow(() -> new RuntimeException(String.format("UserCourseLesson not found [%d, %d, %d]", userId, courseId, lessonId)));
        existingUserCourseLesson.setStatus("inactive");
        userCourseLessonRepos.save(existingUserCourseLesson);

        return existingUserCourseLesson;
    }

    // // Start
    // @Override
    // public Object start(String lessonId) {
    //     return lessonId;
    // }

    // // Stop
    // @Override
    // public Object stop(String lessonId) {
    //     return lessonId;
    // }

    // // Finish
    // @Override
    // public Object finish(String lessonId) {
    //     return lessonId;
    // }
}
