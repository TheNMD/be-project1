package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.constant.RegexConst;
import be_project1.pet_project.dto.request.ChapterManageReq;

@Service("chapterServiceVal")
public class ChapterServiceVal {
    // Check ID
    public String checkID(String id) {
        // Not numeric
        if (!id.matches(RegexConst.ID)) {
            return "ID is not valid! (Not a positive integer)";
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
    public String create(ChapterManageReq request) {
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String result;

        // Chapter Name
        if (chapterName != null) {
            result = checkChapterName(chapterName);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Chapter Name not entered!";
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
    public String read(ChapterManageReq request) {
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String result;

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

    // Update
    public String update(String id, ChapterManageReq request) {
        String chapterName = request.getChapterName();
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String result;

        // ChapterID
        result = checkID(id);
        if (result != null) {
            return result;
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
        // ChapterID
        return checkID(id);
    }
}
