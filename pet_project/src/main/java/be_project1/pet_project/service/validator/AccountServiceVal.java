package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.dto.request.LoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;

@Service("accountServiceVal")
public class AccountServiceVal {
    // Check UserID
    public String checkUserID(String userID) {
        // Not numeric
        if (!userID.matches("\\d+")) {
            return "Account ID is not numeric!";
        }
        
        return null;
    }
    
    // Check username
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
        if (!username.matches("[a-zA-Z0-9]+")) {
            return "Username contains special characters";
        }

        return null;
    }

    // Check password
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
        if (password.matches(".*\\s.*")) {
            return "Password contains spaces";
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
        if (!name.matches("[a-zA-Z ]+")) {
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

    // Check date
    public String checkDate(String date) {
        // Empty
        if (date.isEmpty()) {
            return "Created Date is empty!";
        }
        // Not following the datetime format
        if (!date.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")) {
            return "Created Date is invalid!";
        }

        return null;
    }

    // Login
    public String login(LoginReq request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String result;

        // Username
        if (username == null) {
            return "Username is empty!";
        }
        result = checkUsername(username);
        if (result != null) {
            return result;
        }

        // Password
        if (password == null) {
            return "Password is empty!";
        }
        result = checkPassword(password);
        if (result != null) {
            return result;
        }
        
        return null;
    }

    // Logout
    public String logout(String userID) {
        // UserID
        return checkUserID(userID);
    }

    // Create
    public String create(AccountManageReq request) {
        String username    = request.getUsername();
        String password    = request.getPassword();
        String name        = request.getName();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String result;

        // Username
        if (username == null) {
            return "Username is empty!";
        }
        result = checkUsername(username);
        if (result != null) {
            return result;
        }

        // Password
        if (password == null) {
            return "Password is empty!";
        }
        result = checkPassword(password);
        if (result != null) {
            return result;
        }

        // Name
        if (name == null) {
            return "Name is empty!";
        }
        result = checkName(name);
        if (result != null) {
            return result;
        }

        // Status
        if (status == null) {
            return "Status is empty!";
        }
        result = checkStatus(status);
        if (result != null) {
            return result;
        }

        // Created Date
        // Empty
        if (createdDate == null) {
            return "Created Date is empty!";
        }
        result = checkDate(createdDate);
        if (result != null) {
            return result;
        }

        return null;
    }

    // Delete
    public String delete(String userID) {
        // UserID
        return checkUserID(userID);
    }

    // Update
    public String update(String userID, AccountManageReq request) {
        String username    = request.getUsername();
        String password    = request.getPassword();
        String name        = request.getName();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
        String result;
        
        // UserID
        result = checkUserID(userID);
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

        return null;
    }

    // Update
    public String search(AccountManageReq request) {
        String username    = request.getUsername();
        String name        = request.getName();
        String status      = request.getStatus();
        String createdDate = request.getCreatedDate();
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

        return null;
    }
}
