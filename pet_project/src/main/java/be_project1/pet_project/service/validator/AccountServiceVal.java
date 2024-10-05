package be_project1.pet_project.service.validator;

import org.springframework.stereotype.Service;

import be_project1.pet_project.dto.request.AccountLoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;

@Service("userServiceVal")
public class AccountServiceVal {
    public String loginVal(AccountLoginReq request) {
        String username = request.getUsername();
        String password = request.getPassword();

        // Empty
        if (username == null || username.isEmpty()) {
            return "Accountname is empty!";
        }
        // Too long
        if (username.length() > 50) {
            return "Accountname is too long (More than 50 characters)";
        }
        // Too short
        if (username.length() < 3) {
            return "Accountname is too short (Less than 3 characters)";
        }
        // Contains special characters
        if (!username.matches("[a-zA-Z0-9]+")) {
            return "Accountname contains special characters";
        }

        // Empty
        if (password == null || password.isEmpty()) {
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

    public String logoutVal(String userID) {
        // Not numeric
        if (!userID.matches("\\d+")) {
            return "Account ID is not numeric!";
        }
        return null;
    }
}
