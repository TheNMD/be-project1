package be_project1.pet_project.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.service.validator.AccountServiceVal;
import be_project1.pet_project.dto.request.AccountLoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;
import be_project1.pet_project.dto.response.AccountManageRes;

@Service("userServiceImpl")
public class AccountServiceImpl implements AccountService {

    // Init
    private final AccountServiceVal userServiceVal;

    @Autowired
    public AccountServiceImpl(@Qualifier("userServiceVal") AccountServiceVal userServiceVal) {
        this.userServiceVal = userServiceVal;
    }

    // Login
    @Override
    public Object login(AccountLoginReq request) {
        String error = userServiceVal.loginVal(request);
        if (error != null) {
            return error;
        }
        // TODO
        return request;
    }

    // Logout
    @Override
    public Object logout(String userID) {
        String error = userServiceVal.logoutVal(userID);
        if (error != null) {
            return error;
        }
        // TODO
        return "Account " + userID + " logout!";
    }

    // Create
    @Override
    public Object createAccount(AccountManageReq request) {
        // TODO
        return request;
    }

    // Delete
    @Override
    public Object deleteAccount(String userID) { 
        // TODO
        return "Account " + userID + " deleted!";
    }

    // Update
    @Override
    public Object updateAccount(AccountManageReq request) { 
        // TODO
        return request;
    }

    // Search
    @Override
    public Object searchAccount(String sort, int page, int size, AccountManageReq request) {
        // TODO

        AccountManageRes response = new AccountManageRes();

        response.setAccountname(request.getAccountname());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }
}
