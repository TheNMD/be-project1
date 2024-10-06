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
        // Contains special characters
        if (!courseName.matches(RegexConst.NAME)) {
            return "Course Name contains special characters";
        }

        return null;
    }

    // Check name
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
}
