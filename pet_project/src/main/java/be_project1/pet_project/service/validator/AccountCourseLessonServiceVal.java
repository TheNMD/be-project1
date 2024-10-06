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
    
    // Check Username
    public String checkUsername(String username) {
        // Empty
        if (username.isEmpty()) {
            return "Username is empty!";
        }
        // Too long
        if (username.length() > 50) {
            return "Username is too long (More than 50 characters)";
        }
        // Too short
        if (username.length() < 3) {
            return "Username is too short (Less than 3 characters)";
        }
        // Contains special characters
        if (!username.matches(RegexConst.USERNAME)) {
            return "Username contains special characters";
        }

        return null;
    }

    // Check Password
    public String checkPassword(String password) {
        // Empty
        if (password.isEmpty()) {
            return "Password is empty!";
        }
        // Too long
        if (password.length() > 64) {
            return "Password is too long (More than 64 characters)";
        }
        // Too short
        if (password.length() < 10) {
            return "Password is too short (Less than 10 characters)";
        }
        // Contains spaces
        if (password.matches(RegexConst.PASSWORD)) {
            return "Password contains spaces";
        }

        return null;
    }

    // Check Name
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
}
