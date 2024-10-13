package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.AccountReq;

public interface AccountService {
    // Login
    public Object login(AccountReq request);

    // Logout
    public Object logout(String accountID);

    // Create
    public Object create(AccountReq request);

     // Update
    public Object update(String accountID, AccountReq request);

    // Search
    public Object read(String sort, int page, int size, AccountReq request);

    // Delete
    public Object delete(String accountID);
}
