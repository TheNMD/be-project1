package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.constant.RegexConst;
import be_project1.pet_project.dto.request.LessonReq;

@Service("lessonServiceVal")
public class LessonServiceVal {
        // Check ID
    public String checkID(String id) {
        // Not numeric
        if (!id.matches(RegexConst.ID)) {
            return "ID is not valid! (Not a non-negative integer)";
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

    // Check URL
    public String checkURL(String url) {
        // Empty
        if (url.isEmpty()) {
            return "URL is empty!";
        }
        // Too long
        if (url.length() > 200) {
            return "URL is too long (More than 200 characters)";
        }
        // Not valid
        if (!url.matches(RegexConst.URL)) {
            return "URL is not valid!";
        }

        return null;
    }

    // Check Order
    public String checkOrder(String order) {
        // Empty
        if (order.isEmpty()) {
            return "Order is empty!";
        }
        // Not numeric
        if (!order.matches(RegexConst.ORDER)) {
            return "Order is not valid! (Not a non-negative integer)";
        }
        // Less than 0
        int orderNum = Integer.parseInt(order);
        if (orderNum < 0) {
            return "Order out of bound! (Less than 0)";
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

    // Check Created & Updated Date
    public String checkDate(String date) {
        // Empty
        if (date.isEmpty()) {
            return "Date is empty!";
        }
        // Not following the datetime format
        if (!date.matches(RegexConst.DATETIME)) {
            return "Date is invalid!";
        }

        return null;
    }

    // Create
    public String create(LessonReq request) {
        String lessonName  = request.getLessonName();
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String type        = request.getType();
        String url         = request.getUrl();
        String order       = request.getOrder();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
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

        // URL
        if (url != null) {
            result = checkURL(url);
            if (result != null) {
                return result;
            }
        }

        // Order
        if (order != null) {
            result = checkOrder(order);
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

        // Updated Date
        if (updatedDate != null) {
            result = checkDate(updatedDate);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    // Read
    public String read(LessonReq request) {
        String lessonName  = request.getLessonName();
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String type        = request.getType();
        String url         = request.getUrl();
        String order       = request.getOrder();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
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

        // URL
        if (url != null) {
            result = checkURL(url);
            if (result != null) {
                return result;
            }
        }

        // Order
        if (order != null) {
            result = checkOrder(order);
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

        // Updated Date
        if (updatedDate != null) {
            result = checkDate(updatedDate);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    // Update
    public String update(String id, LessonReq request) {
        String lessonName  = request.getLessonName();
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String type        = request.getType();
        String url         = request.getUrl();
        String order       = request.getOrder();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
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

        // URL
        if (url != null) {
            result = checkURL(url);
            if (result != null) {
                return result;
            }
        }

        // Order
        if (order != null) {
            result = checkOrder(order);
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

        // Updated Date
        if (updatedDate != null) {
            result = checkDate(updatedDate);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Updated Date not entered!";
        }

        return null;
    }

    // Delete
    public String delete(String id) {
        // LessonID
        return checkID(id);
    }
}
