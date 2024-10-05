package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.LoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;

public interface AccountService {
    // Login
    public Object login(LoginReq request);

    // Logout
    public Object logout(String accountID);

    // Create
    public Object create(AccountManageReq request);

    // Delete
    public Object delete(String accountID);

     // Update
    public Object update(String accountID, AccountManageReq request);

    // Search
    public Object search(String sort, int page, int size, AccountManageReq request);
}
