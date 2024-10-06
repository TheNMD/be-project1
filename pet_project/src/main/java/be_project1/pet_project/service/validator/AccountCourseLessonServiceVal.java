package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.constant.RegexConst;
import be_project1.pet_project.dto.request.AccountCourseLessonReq;

@Service("accountCourseLessonServiceVal")
public class AccountCourseLessonServiceVal {
    // Check AccountID
    public String checkID(String id) {
        // Not numeric
        if (!id.matches(RegexConst.ID)) {
            return "ID is not valid! (Not a non-negative integer)";
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
    public String create(AccountCourseLessonReq request) {
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
        String result;

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
    public String read(AccountCourseLessonReq request) {
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
        String result;

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
    public String update(String id, AccountCourseLessonReq request) {
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
        String result;
        
        // LessonID
        result = checkID(id);
        if (result != null) {
            return result;
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

    // Start
    public String start(String id) {
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
