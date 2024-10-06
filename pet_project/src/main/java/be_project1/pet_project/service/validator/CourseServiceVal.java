package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.constant.RegexConst;
import be_project1.pet_project.dto.request.CourseManageReq;

@Service("courseServiceVal")
public class CourseServiceVal {
    // Check ID
    public String checkID(String id) {
        // Not numeric
        if (!id.matches(RegexConst.ID)) {
            return "ID is not valid! (Not a positive integer)";
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

    // Check Teacher Name
    public String checkName(String name) {
        // Empty
        if (name.isEmpty()) {
            return "Name is empty!";
        }
        // Too long
        if (name.length() > 50) {
            return "Name is too long (More than 50 characters)";
        }
        // Contains special characters
        if (!name.matches(RegexConst.NAME)) {
            return "Name contains special characters";
        }

        return null;
    }

    // Check status
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

    // Check rating
    public String checkRating(String rating) {
        // Empty
        if (rating.isEmpty()) {
            return "Rating is empty!";
        }
        if (!rating.matches(RegexConst.RATING)) {
            return "Rating is invalid!";
        }
        // Less than 0 or more than 5
        double ratingNum = Double.parseDouble(rating);
        if (ratingNum < 0 || ratingNum > 5) {
            return "Rating out of bound! (Less than 0 or more than 5)";
        }

        return null;
    }

    // Check review
    public String checkReview(String review) {
        // Empty
        if (review.isEmpty()) {
            return "Review is empty!";
        }
        // Too long
        if (review.length() > 300) {
            return "Review is too long (More than 300 characters)";
        }

        return null;
    }

    // Check date
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
    public String create(CourseManageReq request) {
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String teacherName = request.getTeacherName();
        String status      = request.getStatus();
        String rating      = request.getRating();
        String review      = request.getReview();
        String createdDate = request.getCreatedDate();
        String result;

        // Course Name
        if (courseName != null) {
            result = checkCourseName(courseName);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Course Name not entered!";
        }

        // Description
        if (description != null) {
            result = checkDescription(description);
            if (result != null) {
                return result;
            }
        }

        // Teacher Name
        if (teacherName != null) {
            result = checkName(teacherName);
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

        // Rating
        if (rating != null) {
            result = checkRating(rating);
            if (result != null) {
                return result;
            }
        }

        // Review
        if (review != null) {
            result = checkReview(review);
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
        else {
            return "Created Date not entered!";
        }

        return null;
    }

    // Read
    public String read(CourseManageReq request) {
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String teacherName = request.getTeacherName();
        String status      = request.getStatus();
        String rating      = request.getRating();
        String review      = request.getReview();
        String createdDate = request.getCreatedDate();
        String result;

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

        // Teacher Name
        if (teacherName != null) {
            result = checkName(teacherName);
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

        // Rating
        if (rating != null) {
            result = checkRating(rating);
            if (result != null) {
                return result;
            }
        }

        // Review
        if (review != null) {
            result = checkReview(review);
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
    public String update(String id, CourseManageReq request) {
        String courseName  = request.getCourseName();
        String description = request.getDescription();
        String teacherName = request.getTeacherName();
        String status      = request.getStatus();
        String rating      = request.getRating();
        String review      = request.getReview();
        String createdDate = request.getCreatedDate();
        String result;
        
        // CourseID
        result = checkID(id);
        if (result != null) {
            return result;
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

        // Teacher Name
        if (teacherName != null) {
            result = checkName(teacherName);
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

        // Rating
        if (rating != null) {
            result = checkRating(rating);
            if (result != null) {
                return result;
            }
        }

        // Review
        if (review != null) {
            result = checkReview(review);
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
        // CourseID
        return checkID(id);
    }

    public String view(String id) {
        // CourseID
        return checkID(id);
    }

    public String join(String id) {
        // CourseID
        return checkID(id);
    }

    public String rate(String id, CourseManageReq request) {
        String rating = request.getRating();
        String result;
        
        // CourseID
        result = checkID(id);
        if (result != null) {
            return result;
        }

        // Rating
        if (rating != null) {
            result = checkRating(rating);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    public String review(String id, CourseManageReq request) {
        String review = request.getReview();
        String result;
        
        // CourseID
        result = checkID(id);
        if (result != null) {
            return result;
        }

        // Review
        if (review != null) {
            result = checkReview(review);
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}
