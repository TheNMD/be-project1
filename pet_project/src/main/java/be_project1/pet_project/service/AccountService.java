package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.AccountLoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;

public interface AccountService {
    // Login
    public Object login(AccountLoginReq request);

    // Logout
    public Object logout(String userID);

    // Create
    public Object createAccount(AccountManageReq request);

    // Delete
    public Object deleteAccount(String userID);

     // Update
    public Object updateAccount(AccountManageReq request);

    // Search
    public Object searchAccount(String sort, int page, int size, AccountManageReq request);
}
