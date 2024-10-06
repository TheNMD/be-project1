package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.constant.RegexConst;
import be_project1.pet_project.dto.request.LessonManageReq;

@Service("lessonServiceVal")
public class LessonServiceVal {
        // Check ID
    public String checkID(String id) {
        // Not numeric
        if (!id.matches(RegexConst.ID)) {
            return "ID is not valid! (Not a positive integer)";
        }
        
        return null;
    }

    // Check Lesson Name
    public String checkLessonName(String lessonName) {
        // Empty
        if (lessonName.isEmpty()) {
            return "Lesson Name is empty!";
        }
        // Too long
        if (lessonName.length() > 100) {
            return "Lesson Name is too long (More than 100 characters)";
        }

        return null;
    }

    // Check Chapter Name
    public String checkChapterName(String chapterName) {
        // Empty
        if (chapterName.isEmpty()) {
            return "Chapter Name is empty!";
        }
        // Too long
        if (chapterName.length() > 100) {
            return "Chapter Name is too long (More than 100 characters)";
        }

        return null;
    }

    // Check Course Name
    public String checkCourseName(String courseName) {
        // Empty
        if (courseName.isEmpty()) {
            return "Course Name is empty!";
        }
        // Too long
        if (courseName.length() > 100) {
            return "Course Name is too long (More than 100 characters)";
        }

        return null;
    }

    // Check Description
    public String checkDescription(String description) {
        // Empty
        if (description.isEmpty()) {
            return "Description is empty!";
        }
        // Too long
        if (description.length() > 1000) {
            return "Description is too long (More than 1000 characters)";
        }

        return null;
    }

    // Check Type
    public String checkType(String type) {
        // Empty
        if (type.isEmpty()) {
            return "Type is empty!";
        }
        // Contain value different than "video" and "slide"
        if (!type.equals("video") && !type.equals("slide")) {
            return "Type is invalid!";
        }

        return null;
    }

    // Check Status
    public String checkStatus(String status) {
        // Empty
        if (status.isEmpty()) {
            return "Status is empty!";
        }
        // Contain value different than "active" and "inactive"
        if (!status.equals("active") && !status.equals("inactive")) {
            return "Status is invalid!";
        }

        return null;
    }

    // Check Created Date
    public String checkDate(String date) {
        // Empty
        if (date.isEmpty()) {
            return "Created Date is empty!";
        }
        // Not following the datetime format
        if (!date.matches(RegexConst.DATETIME)) {
            return "Created Date is invalid!";
        }

        return null;
    }

    // Create
    public String create(LessonManageReq request) {
        String lessonName  = request.getLessonName();
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String type        = request.getType();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String result;

        // Lesson Name
        if (lessonName != null) {
            result = checkLessonName(lessonName);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Lesson Name not entered!";
        }

        // Chapter Name
        if (chapterName != null) {
            result = checkChapterName(chapterName);
            if (result != null) {
                return result;
            }
        }

        // Course Name
        if (courseName != null) {
            result = checkCourseName(courseName);
            if (result != null) {
                return result;
            }
        }

        // Description
        if (description != null) {
            result = checkDescription(description);
            if (result != null) {
                return result;
            }
        }

        // Type
        if (type != null) {
            result = checkType(type);
            if (result != null) {
                return result;
            }
        }

        // Status
        if (status != null) {
            result = checkStatus(status);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Status not entered!";
        }

        // Created Date
        if (createdDate != null) {
            result = checkDate(createdDate);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Created Date not entered!";
        }

        return null;
    }

    // Read
    public String read(LessonManageReq request) {
        String lessonName  = request.getLessonName();
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String type        = request.getType();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String result;

        // Lesson Name
        if (lessonName != null) {
            result = checkLessonName(lessonName);
            if (result != null) {
                return result;
            }
        }

        // Chapter Name
        if (chapterName != null) {
            result = checkChapterName(chapterName);
            if (result != null) {
                return result;
            }
        }

        // Course Name
        if (courseName != null) {
            result = checkCourseName(courseName);
            if (result != null) {
                return result;
            }
        }

        // Description
        if (description != null) {
            result = checkDescription(description);
            if (result != null) {
                return result;
            }
        }

        // Type
        if (type != null) {
            result = checkType(type);
            if (result != null) {
                return result;
            }
        }

        // Status
        if (status != null) {
            result = checkStatus(status);
            if (result != null) {
                return result;
            }
        }

        // Created Date
        if (createdDate != null) {
            result = checkDate(createdDate);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    // Create
    public String update(String id, LessonManageReq request) {
        String lessonName  = request.getLessonName();
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String type        = request.getType();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String result;

        // LessonID
        result = checkID(id);
        if (result != null) {
            return result;
        }

        // Lesson Name
        if (lessonName != null) {
            result = checkLessonName(lessonName);
            if (result != null) {
                return result;
            }
        }

        // Chapter Name
        if (chapterName != null) {
            result = checkChapterName(chapterName);
            if (result != null) {
                return result;
            }
        }

        // Course Name
        if (courseName != null) {
            result = checkCourseName(courseName);
            if (result != null) {
                return result;
            }
        }

        // Description
        if (description != null) {
            result = checkDescription(description);
            if (result != null) {
                return result;
            }
        }

        // Type
        if (type != null) {
            result = checkType(type);
            if (result != null) {
                return result;
            }
        }

        // Status
        if (status != null) {
            result = checkStatus(status);
            if (result != null) {
                return result;
            }
        }

        // Created Date
        if (createdDate != null) {
            result = checkDate(createdDate);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    // Delete
    public String delete(String id) {
        // LessonID
        return checkID(id);
    }

    // Begin
    public String begin(String id) {
        // LessonID
        return checkID(id);
    }

    // Stop
    public String stop(String id) {
        // LessonID
        return checkID(id);
    }

    // Finish
    public String finish(String id) {
        // LessonID
        return checkID(id);
    }
}
