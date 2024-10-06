package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.constant.RegexConst;
import be_project1.pet_project.dto.request.AccountCourseReq;

@Service("accountCourseServiceVal")
public class AccountCourseServiceVal {
    // Check ID
    public String checkID(String id) {
        // Not numeric
        if (!id.matches(RegexConst.ID)) {
            return "ID is not valid! (Not a non-negative integer)";
        }
        
        return null;
    }
    
    // Check Rating
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

    // Check Review
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

    // Check Status
    public String checkStatus(String status) {
        // Empty
        if (status.isEmpty()) {
            return "Status is empty!";
        }
        // Contain value different than "started" and "stopped" and "finised"
        if (!status.equals("started") && !status.equals("stopped") && !status.equals("finised")) {
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
    public String create(AccountCourseReq request) {
        String rating      = request.getRating();
        String review      = request.getReview();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
        String result;

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
    public String read(AccountCourseReq request) {
        String rating      = request.getRating();
        String review      = request.getReview();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
        String result;

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
    public String update(String id, AccountCourseReq request) {
        String rating      = request.getRating();
        String review      = request.getReview();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
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

        // Review
        if (review != null) {
            result = checkReview(review);
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

    public String rate(String id, AccountCourseReq request) {
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

    public String review(String id, AccountCourseReq request) {
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
