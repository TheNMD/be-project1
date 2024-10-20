package be_project1.pet_project.service;

import be_project1.pet_project.dto.request.AccountLoginReq;
import be_project1.pet_project.dto.request.AccountCreateReq;
import be_project1.pet_project.dto.request.AccountReadReq;
import be_project1.pet_project.dto.request.AccountUpdateReq;

public interface AccountService {
    // Login
    public Object login(AccountLoginReq request);

    // Logout
    public Object logout(String accountID);

    // Create
    public Object create(AccountCreateReq request);

    // Read
    public Object read(String sort, int page, int size, AccountReadReq request);

     // Update
    public Object update(String accountID, AccountUpdateReq request);

    // Delete
    public Object delete(String accountID);
}
