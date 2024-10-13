package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.constant.RegexConst;
import be_project1.pet_project.dto.request.AccountReq;

@Service("accountServiceVal")
public class AccountServiceVal {
    // Check ID
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

    // Login
    public String login(AccountReq request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String result;

        // Username
        if (username != null) {
            result = checkUsername(username);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Username not entered!";
        }

        // Password
        if (password != null) {
            result = checkPassword(password);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Password not entered!";
        }
        
        return null;
    }

    // Logout
    public String logout(String id) {
        // AccountID
        return checkID(id);
    }

    // Create
    public String create(AccountReq request) {
        String username    = request.getUsername();
        String password    = request.getPassword();
        String name        = request.getName();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
        String result;

        // Username
        if (username != null) {
            result = checkUsername(username);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Username not entered!";
        }

        // Password
        if (password != null) {
            result = checkPassword(password);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Password not entered!";
        }

        // Name
        if (name != null) {
            result = checkName(name);
            if (result != null) {
                return result;
            }
        }
        else {
            return "Name not entered!";
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
    public String read(AccountReq request) {
        String username    = request.getUsername();
        String name        = request.getName();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
        String result;
    
        // Username
        if (username != null) {
            result = checkUsername(username);
            if (result != null) {
                return result;
            }
        }

        // Name
        if (name != null) {
            result = checkName(name);
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
    public String update(String id, AccountReq request) {
        String username    = request.getUsername();
        String password    = request.getPassword();
        String name        = request.getName();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String updatedDate = request.getUpdatedDate();
        String result;
        
        // AccountID
        result = checkID(id);
        if (result != null) {
            return result;
        }

        // Username
        if (username != null) {
            result = checkUsername(username);
            if (result != null) {
                return result;
            }
        }

        // Password
        if (password != null) {
            result = checkPassword(password);
            if (result != null) {
                return result;
            }
        }

        // Name
        if (name != null) {
            result = checkName(name);
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
        // AccountID
        return checkID(id);
    }
}
